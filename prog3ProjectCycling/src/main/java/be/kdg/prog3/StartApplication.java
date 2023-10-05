package be.kdg.prog3;

import be.kdg.prog3.presenter.Presenter;
import be.kdg.prog3.presenter.View;
import be.kdg.prog3.service.CyclistService;
import be.kdg.prog3.service.CyclistServiceImpl;
import be.kdg.prog3.service.TeamService;
import be.kdg.prog3.service.TeamServiceImpl;

public class StartApplication {
    public static void main(String[] args) {
        CyclistService cyclistService = new CyclistServiceImpl();
        TeamService teamService = new TeamServiceImpl();
        View view = new View();
        Presenter presenter = new Presenter(cyclistService, teamService, view);
        presenter.startApplication();
    }
}

