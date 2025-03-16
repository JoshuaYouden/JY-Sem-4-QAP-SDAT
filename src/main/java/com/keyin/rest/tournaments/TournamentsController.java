package com.keyin.rest.tournaments;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/api")
@RestController
@CrossOrigin
public class TournamentsController {
    @Autowired
    private TournamentsService tournamentsService;

    @GetMapping("/tournaments")
    public List<Tournaments> getAllTournaments() {
        return tournamentsService.findAllTournaments();
    }

    @GetMapping("/tournaments/{id}")
    public Tournaments getTournamentById(@PathVariable(value = "id") long id) {
        return tournamentsService.findTournamentById(id);
    }

    @PostMapping("/tournaments_search")
    public List<Tournaments> searchTournaments(@RequestBody Tournaments tournaments) {
        List<Tournaments> results = new ArrayList<Tournaments>();

        if (tournaments.getTournamentLocation() != null) {
            Tournaments tournament = tournamentsService.findTournamentByLocation(tournaments.getTournamentLocation());

            if (tournament != null) {
                results.add(tournament);
            }
        }

        if (tournaments.getTournamentStartDate() != null) {
            Tournaments tournament = tournamentsService.findTournamentByStartDate(tournaments.getTournamentStartDate());

            if (tournament != null) {
                results.add(tournament);
            }
        }

        if (tournaments.getParticipatingMembers() != null) {
            Tournaments tournament = tournamentsService.findTournamentByParticipatingMembers(tournaments.getParticipatingMembers());

            if (tournament != null) {
                results.add(tournament);
            }
        }

        return results;
    }

    @PostMapping("/tournaments")
    public Tournaments createTournament(@RequestBody Tournaments newTournament) {
        return tournamentsService.createTournament(newTournament);
    }

    @PutMapping("/tournaments/{id}")
    public Tournaments updateTournament(@PathVariable(value = "id") long id, @RequestBody Tournaments updatedTournament) {
        return tournamentsService.updateTournament(id, updatedTournament);
    }
}
