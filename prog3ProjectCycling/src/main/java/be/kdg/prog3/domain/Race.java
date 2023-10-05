package be.kdg.prog3.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Race {
    public enum RaceCategory {
        ONEDAY, GRAND_TOUR,CLASSICS,MONUMENTS, STAGES
    }

    private final String raceName;
    private final LocalDate date;
    private final String location;
    private RaceCategory category;
    private final List<Cyclist> cyclists; // Many-to-many relationship with Cyclist

    public Race(String raceName, LocalDate date, String location, RaceCategory category) {
        this.raceName = raceName;
        this.date = date;
        this.location = location;
        this.category = category;
        this.cyclists = new ArrayList<>();
    }

    public String getRaceName() {
        return raceName;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public RaceCategory getCategory() {
        return category;
    }

    public void setCategory(RaceCategory category) {
        this.category = category;
    }

    public List<Cyclist> getCyclists() {
        return cyclists;
    }

    public void addCyclist(Cyclist cyclist) {
        cyclists.add(cyclist);
        cyclist.getRaces().add(this); // Adding the race to the cyclist's list of races
    }

    @Override
    public String toString() {
        return "RaceName='" + raceName + "', date=" + date + ", location='" + location + "', category=" + category + "";
    }
}