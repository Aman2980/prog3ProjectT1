package be.kdg.prog3.domain;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private final String teamName;
    private final String sponsor;
    private final String country;
    private final String bikeBrand;
    private final int founded;
    private final List<Cyclist> cyclists; // One-to-many relationship with Cyclist

    public Team(String teamName, String sponsor, String country, String bikeBrand, int founded) {
        this.teamName = teamName;
        this.sponsor = sponsor;
        this.country = country;
        this.bikeBrand = bikeBrand;
        this.founded = founded;
        this.cyclists = new ArrayList<>();
    }

    public String getBikeBrand() {
        return bikeBrand;
    }

    public int getFounded() {
        return founded;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getSponsor() {
        return sponsor;
    }

    public String getCountry() {
        return country;
    }

    public List<Cyclist> getCyclists() {
        return cyclists;
    }

    public void addCyclist(Cyclist cyclist) {
        cyclists.add(cyclist);
        cyclist.setTeam(this); // Setting the cyclist's team to this team
    }

    @Override
    public String toString() {
        return "Team{teamName='" + teamName + "', sponsor='" + sponsor + "', country='" + country + "'}";
    }
}