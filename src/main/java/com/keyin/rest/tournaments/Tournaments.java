package com.keyin.rest.tournaments;

import java.util.List;

import com.keyin.rest.members.Members;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Tournaments {
    @Id
    @SequenceGenerator(name = "tournaments_sequence", sequenceName = "tournaments_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "tournaments_sequence")
    private long id;
    private String tournamentLocation;
    private String tournamentStartDate;
    private String tournamentEndDate;
    private int tournamentEntryFee;
    private int tournamentCashPrize;

    @ManyToMany
    @JoinTable(
    name = "tournament_members",
    joinColumns = @JoinColumn(name = "tournament_id"),
    inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<Members> participatingMembers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTournamentLocation() {
        return tournamentLocation;
    }

    public void setTournamentLocation(String tournamentLocation) {
        this.tournamentLocation = tournamentLocation;
    }

    public String getTournamentStartDate() {
        return tournamentStartDate;
    }

    public void setTournamentStartDate(String tournamentStartDate) {
        this.tournamentStartDate = tournamentStartDate;
    }

    public String getTournamentEndDate() { 
        return tournamentEndDate;
    }

    public void setTournamentEndDate(String tournamentEndDate) {
        this.tournamentEndDate = tournamentEndDate;
    }

    public int getTournamentEntryFee() {
        return tournamentEntryFee;
    }

    public void setTournamentEntryFee(int tournamentEntryFee) {
        this.tournamentEntryFee = tournamentEntryFee;
    }

    public int getTournamentCashPrize() {
        return tournamentCashPrize;
    }

    public void setTournamentCashPrize(int tournamentCashPrize) {
        this.tournamentCashPrize = tournamentCashPrize;
    }

    public List<Members> getParticipatingMembers() {
        return participatingMembers;
    }

    public void setParticipatingMembers(List<Members> participatingMembers) {
        this.participatingMembers = participatingMembers;
    }
}
