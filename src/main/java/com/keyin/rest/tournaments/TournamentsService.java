package com.keyin.rest.tournaments;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keyin.rest.members.Members;
import com.keyin.rest.members.MembersRepository;

@Service
public class TournamentsService {
    @Autowired
    private TournamentsRepository tournamentsRepository;

    @Autowired
    private MembersRepository membersRepository;

    public List<Tournaments> findAllTournaments() {
        return (List<Tournaments>) tournamentsRepository.findAll();
    }

    public Tournaments findTournamentById(long id) {
        Optional<Tournaments> optionalTournaments = tournamentsRepository.findById(id);

        return optionalTournaments.orElse(null);
    }

    public Tournaments findTournamentByLocation(String tournamentLocation) {
        return tournamentsRepository.findByTournamentLocation(tournamentLocation);
    }

    public Tournaments findTournamentByStartDate(String tournamentStartDate) {
        return tournamentsRepository.findByTournamentStartDate(tournamentStartDate);
    }

    public Tournaments findTournamentByParticipatingMembers(Members participatingMembers) {
        return tournamentsRepository.findByParticipatingMembers(participatingMembers);
    }

    public Tournaments addMemberToTournament(long tournamentId, long memberId) {
    Optional<Tournaments> optionalTournament = tournamentsRepository.findById(tournamentId);
    Optional<Members> optionalMember = membersRepository.findById(memberId);

    if (optionalTournament.isPresent() && optionalMember.isPresent()) {
        Tournaments tournament = optionalTournament.get();
        Members member = optionalMember.get();

        if (tournament.getParticipatingMembers() == null) {
            tournament.setParticipatingMembers(new ArrayList<>());
        }

        if (!tournament.getParticipatingMembers().contains(member)) {
            tournament.getParticipatingMembers().add(member);
            return tournamentsRepository.save(tournament);
        }
    }

    return null;
}

    public Tournaments createTournament(Tournaments newTournament) {
        return tournamentsRepository.save(newTournament);
    }

    public Tournaments updateTournament(long id, Tournaments updatedTournament) {
        Tournaments tournamentToUpdate = findTournamentById(id);

        if (tournamentToUpdate != null) {
            tournamentToUpdate.setTournamentLocation(updatedTournament.getTournamentLocation());
            tournamentToUpdate.setTournamentStartDate(updatedTournament.getTournamentStartDate());
            tournamentToUpdate.setTournamentEndDate(updatedTournament.getTournamentEndDate());
            tournamentToUpdate.setTournamentEntryFee(updatedTournament.getTournamentEntryFee());
            tournamentToUpdate.setTournamentCashPrize(updatedTournament.getTournamentCashPrize());
            tournamentToUpdate.setParticipatingMembers(updatedTournament.getParticipatingMembers());

            return tournamentsRepository.save(tournamentToUpdate);
        }

        return null;
    }
}
