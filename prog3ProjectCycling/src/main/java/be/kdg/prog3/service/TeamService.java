package be.kdg.prog3.service;

import be.kdg.prog3.domain.Team;

import java.util.List;

public interface TeamService {

    List<Team> getAllTeams();

    List<Team> getTeamsFiltered();
}
