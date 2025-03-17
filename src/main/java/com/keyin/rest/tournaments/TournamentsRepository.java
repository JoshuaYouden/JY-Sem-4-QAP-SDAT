package com.keyin.rest.tournaments;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.keyin.rest.members.Members;

@Repository
public interface TournamentsRepository extends CrudRepository<Tournaments, Long> {
    public Tournaments findByTournamentLocation(String tournamentLocation);
    public Tournaments findByTournamentStartDate(String tournamentStartDate);
    public Tournaments findByTournamentEndDate(String tournamentEndDate);
    public Tournaments findByTournamentEntryFee(int tournamentEntryFee);
    public Tournaments findByTournamentCashPrize(int tournamentCashPrize);
    public Tournaments findByParticipatingMembers(Members participatingMembers);
}
