package be.kdg.prog3.service;

import be.kdg.prog3.domain.Team;
import be.kdg.prog3.repository.DataFactory;

import java.util.List;

public class TeamServiceImpl implements TeamService {
    @Override
    public List<Team> getAllTeams() {
        return DataFactory.teams;
    }

    @Override
    public List<Team> getTeamsFiltered() {
        return DataFactory.teams;

    }
}
