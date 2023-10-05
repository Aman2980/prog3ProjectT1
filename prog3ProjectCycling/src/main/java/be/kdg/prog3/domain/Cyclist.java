package be.kdg.prog3.domain;

import java.util.ArrayList;
import java.util.List;

public class Cyclist {

    private final String name;
    private final int age;
    private final String nationality;
    private Team team; // Many-to-one relationship with Team
    private final List<Race> races; // Many-to-many relationship with Race

    public Cyclist(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.team = null; // Initialize to null, as a cyclist may not belong to a team initially
        this.races = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void addRace(Race race) {
        races.add(race);
        race.addCyclist(this); // Adding the cyclist to the race's list as well
    }

    @Override
    public String toString() {
        return "Name=c" + name + ", age=c" + age + ", nationality= " + nationality + "";
    }
}