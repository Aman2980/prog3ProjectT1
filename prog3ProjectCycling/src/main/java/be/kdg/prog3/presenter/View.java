package be.kdg.prog3.presenter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import be.kdg.prog3.domain.Cyclist;
import be.kdg.prog3.repository.DataFactory;
import be.kdg.prog3.domain.Race;
import be.kdg.prog3.domain.Team;
import be.kdg.prog3.json.JsonDataSaver;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class View {
    private static List<Cyclist> cyclists;
    private static List<Team> teams;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public static void startApplication() {
        try {
            initializeData();
            do {
                printMenu();
                int choice = getUserChoice();
                switch (choice) {
                    case 0 -> exitProgram();
                    case 1 -> showAllCyclists();
                    case 2 -> showCyclistsByNationality();
                    case 3 -> showAllTeams();
                    case 4 -> showTeamsByFilters();
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

    private static void initializeData() {
        DataFactory.seed();
        cyclists = DataFactory.cyclists;
        teams = DataFactory.teams;
        List<Race> races = DataFactory.races;
    }

    private static void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println("==========================");
        System.out.println("0) Quit");
        System.out.println("1) Show all cyclists");
        System.out.println("2) Show cyclists by nationality");
        System.out.println("3) Show all teams");
        System.out.println("4) Show teams by sponsor and/or country and/or foundation year");
        System.out.print("Choice (0-4): ");
    }

    private static int getUserChoice() {
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        }
        scanner.nextLine(); // Consume newline
        return choice;
    }

    private static void exitProgram() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    private static void showAllCyclists() {
        System.out.println("All cyclists");
        System.out.println("=============");
        for (Cyclist cyclist : cyclists) {
            System.out.println(cyclist.getName());
        }
//        saveDataToJson("cyclists.json", cyclists); // Save cyclists data to JSON
        JsonDataSaver.saveDataToJson("cyclists.json", cyclists); // Save cyclists data to JSON

    }

    private static void showCyclistsByNationality() {
        System.out.print("Enter nationality or leave blank: ");
        String nationalityFilter = scanner.nextLine().trim();
        System.out.println("Cyclists by nationality");
        System.out.println("========================");

        // Filter cyclists by nationality
        List<Cyclist> filteredCyclists = new ArrayList<>();
        for (Cyclist cyclist : cyclists) {
            if (nationalityFilter.isEmpty() || cyclist.getNationality().equalsIgnoreCase(nationalityFilter)) {
                System.out.println(cyclist.getName());
                filteredCyclists.add(cyclist);
            }
        }
        // Save filtered cyclists data to JSON, overwriting the file
//        saveDataToJson("cyclists.json", filteredCyclists);
        JsonDataSaver.saveDataToJson("cyclists.json", filteredCyclists);
    }


    private static void showAllTeams() {
        System.out.println("All teams");
        System.out.println("===========");
        for (Team team : teams) {
            System.out.println(team.getTeamName());
        }
//        saveDataToJson("teams.json", teams); // Save teams data to JSON
        JsonDataSaver.saveDataToJson("teams.json", teams); // Save teams data to JSON
    }

    private static void showTeamsByFilters() {
        System.out.print("Enter sponsor or leave blank: ");
        String sponsorFilter = scanner.nextLine().trim();
        System.out.print("Enter country or leave blank: ");
        String countryFilter = scanner.nextLine().trim();
        System.out.print("Enter foundation year or leave blank: ");
        String yearFilterInput = scanner.nextLine().trim();
        int yearFilter = -1; // Initialize to a value that won't match any team by default
        // Check if the user provided a valid year input
        if (!yearFilterInput.isEmpty()) {
            try {
                yearFilter = Integer.parseInt(yearFilterInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid year format. Ignoring year filter.");
            }
        }
        System.out.println("Teams by sponsor, country, and/or foundation year");
        System.out.println("===============================");
        // Filter teams by sponsor, country, and foundation year
        List<Team> filteredTeams = new ArrayList<>();
        for (Team team : teams) {
            if ((sponsorFilter.isEmpty() || team.getSponsor().equalsIgnoreCase(sponsorFilter)) &&
                    (countryFilter.isEmpty() || team.getCountry().equalsIgnoreCase(countryFilter)) &&
                    (yearFilter == -1 || team.getFounded() == yearFilter)) {
                System.out.println(team.getTeamName());
                filteredTeams.add(team);
            }
        }
        // Save filtered teams data to JSON, overwriting the file
//        saveDataToJson("teams.json", filteredTeams);
        JsonDataSaver.saveDataToJson("teams.json", filteredTeams);
    }
}

//    private static void saveDataToJson(String fileName, List<?> data) {
//        try {
//            GsonBuilder gsonBuilder = new GsonBuilder();
//            Gson gson = gsonBuilder.create();
//            String jsonString = gson.toJson(data);
//
//
//            JSONArray jsonArray = new JSONArray(data);
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("data", jsonArray);
//
//            FileWriter fileWriter = new FileWriter(fileName, false); // Open in overwrite mode
//            fileWriter.write(jsonObject.toString(4)); //4-space indentation for formatting
//            fileWriter.close();
//
//            System.out.println("Data saved to " + fileName + "...");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Failed to save data to " + fileName + "...");
//        }
//    }
//}


//    private static void saveDataToJson(String fileName, List<?> data) {
//        try {
//            GsonBuilder gsonBuilder = new GsonBuilder();
//            Gson gson = gsonBuilder.create();
//            String jsonString = gson.toJson(data);
//
//            FileWriter fileWriter = new FileWriter(fileName, false); // Open in overwrite mode
//            fileWriter.write(jsonString);
//            fileWriter.close();
//
//            System.out.println("Data saved to " + fileName + "...");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Failed to save data to " + fileName + "...");
//        }
//    }

