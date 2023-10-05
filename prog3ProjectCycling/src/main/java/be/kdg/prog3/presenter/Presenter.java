package be.kdg.prog3.presenter;

import be.kdg.prog3.service.CyclistService;
import be.kdg.prog3.service.TeamService;

import java.util.List;
import java.util.Scanner;


public class Presenter {
    private final CyclistService cyclistService;
    private final TeamService teamService;
    private final View view;

    private static final Scanner scanner = new Scanner(System.in);

    public Presenter(CyclistService cyclistService, TeamService teamService, View view) {
        this.cyclistService = cyclistService;
        this.teamService = teamService;
        this.view = view;
    }

    public void startApplication() {
        try {
            view.initializeData();
            do {
                view.printMenu();
                int choice = view.getUserChoice();
                switch (choice) {
                    case 0 -> view.exitProgram();
                    case 1 -> view.showAllCyclists(cyclistService.getAllCyclists());
                    case 2 -> view.showCyclistsByNationality(cyclistService.getCyclistsByNationality());
                    case 3 -> view.showAllTeams(teamService.getAllTeams());
                    case 4 -> view.showTeamsByFilters(teamService.getTeamsFiltered());
                    default -> System.out.println("Invalid choice. Please select a valid option.");
                }
                System.out.println(); // Add a newline after each operation
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close(); // Close the scanner
        }
    }
}
