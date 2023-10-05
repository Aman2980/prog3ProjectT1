package be.kdg.prog3.repository;

import be.kdg.prog3.domain.Cyclist;
import be.kdg.prog3.domain.Race;
import be.kdg.prog3.domain.Team;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataFactory {
    public static List<Cyclist> cyclists = new ArrayList<>();
    public static List<Team> teams = new ArrayList<>();
    public static List<Race> races = new ArrayList<>();

    public static void main(String[] args) {
        seed(); // Calls the seed method
        // Loop through teams and print out their riders
        for (Race race : races) {
            System.out.println("Race: " + race.getRaceName());
            System.out.println("Riders:");
            for (Cyclist cyclist : race.getCyclists()) {
                System.out.println("- " + cyclist.getName());
            }
            System.out.println(); // empty line for separation
        }

    }


    public static void seed() {
        Cyclist mvdp = new Cyclist("Mathieu van der Poel", 28, "Dutch");
        Cyclist groves = new Cyclist("Kaden Groves", 24, "Australian");
        Cyclist pogi = new Cyclist("Tadej Pogačar", 25, "Slovenian");
        Cyclist roglic = new Cyclist("Primoz Roglic", 33, "Slovenian");
        Cyclist froome = new Cyclist("Chris Froome", 36, "British");
        Cyclist tarling = new Cyclist("Joshua Tarling", 19, "British");
        Cyclist philipsen = new Cyclist("Jasper Philipsen", 25, "Belgian");
        Cyclist wout = new Cyclist("Wout Van Aert", 29, "Belgian");
        Cyclist ganna = new Cyclist("Filippo Ganna ", 27, "Italian");
        Cyclist remco = new Cyclist("Remco Evenepoel", 23, "Belgian");
        Cyclist egan = new Cyclist("Egan Bernal", 24, "Colombian");
        Cyclist sagan = new Cyclist("Peter Sagan", 31, "Slovakian");
        Cyclist sepp = new Cyclist("Sepp Kuss", 29, "American");
        Cyclist jonas = new Cyclist("Jonas Vingegaard", 26, "Danish");

        cyclists.add(mvdp);
        cyclists.add(groves);
        cyclists.add(pogi);
        cyclists.add(roglic);
        cyclists.add(froome);
        cyclists.add(tarling);
        cyclists.add(philipsen);
        cyclists.add(wout);
        cyclists.add(ganna);
        cyclists.add(remco);
        cyclists.add(egan);
        cyclists.add(sagan);
        cyclists.add(sepp);
        cyclists.add(jonas);


        Team ineos = new Team("Ineos Grenadiers", "Ineos", "United Kingdom", "Pinarello", 2010);
        Team alpecin = new Team("Alpecin–Deceuninck", "Alpecin", "Belgium", "Canyon", 2008);
        Team uae = new Team("UAE Team Emirates", "Colnago", "UAE", "Colnago", 1999);
        Team quickStep = new Team("Soudal Quick-Step", "Quick-Step", "Belgium", "Specialized", 2003);
        Team tjv = new Team("Team Jumbo-Visma", "Jumbo", "Netherlands", "Cervelo", 1984);
        Team bora = new Team("BORA-hansgrohe", "BORA", "Germany", "Specialized", 2010);

        teams.add(ineos);
        teams.add(alpecin);
        teams.add(uae);
        teams.add(quickStep);
        teams.add(tjv);
        teams.add(bora);

        Race tour = new Race("Tour de France", LocalDate.of(2023, 7, 1), "France", Race.RaceCategory.GRAND_TOUR);
        Race giro = new Race("Giro d'Italia", LocalDate.of(2023, 5, 8), "Italy", Race.RaceCategory.GRAND_TOUR);
        Race vuelta = new Race("Vuelta a España", LocalDate.of(2023, 8, 19), "Spain", Race.RaceCategory.GRAND_TOUR);
        Race parisRoubaix = new Race("Paris-Roubaix", LocalDate.of(2023, 4, 9), "France", Race.RaceCategory.MONUMENTS);
        Race amstel = new Race("Amstel Gold Race", LocalDate.of(2023, 4, 9), "Netherlands", Race.RaceCategory.CLASSICS);
        Race tourOfFlanders = new Race("Tour of Flanders", LocalDate.of(2023, 4, 9), "Belgium", Race.RaceCategory.MONUMENTS);
        Race msr = new Race("Milan Sanremo", LocalDate.of(2023, 4, 9), "Italy", Race.RaceCategory.MONUMENTS);
        Race gentWevelgem = new Race("Gent - Wevelgem", LocalDate.of(2023, 4, 9), "Belgium", Race.RaceCategory.CLASSICS);
        Race tourOfBelgium = new Race("Tour of Belgium", LocalDate.of(2023, 4, 9), "Belgium", Race.RaceCategory.STAGES);
        Race uciWorldChamps = new Race("UCI World Championship", LocalDate.of(2023, 4, 9), "Scotland", Race.RaceCategory.ONEDAY);

        races.add(tour);
        races.add(giro);
        races.add(vuelta);
        races.add(parisRoubaix);
        races.add(amstel);
        races.add(tourOfFlanders);
        races.add(msr);
        races.add(gentWevelgem);
        races.add(tourOfBelgium);
        races.add(uciWorldChamps);


        // Many-to-One Relationship: Assign professional cyclists to teams
        ineos.addCyclist(froome);
        ineos.addCyclist(tarling);
        ineos.addCyclist(ganna);
        ineos.addCyclist(egan);
        alpecin.addCyclist(mvdp);
        alpecin.addCyclist(philipsen);
        alpecin.addCyclist(groves);
        uae.addCyclist(pogi);
        quickStep.addCyclist(remco);
        tjv.addCyclist(jonas);
        tjv.addCyclist(sepp);
        tjv.addCyclist(wout);
        tjv.addCyclist(roglic);
        bora.addCyclist(sagan);

        // Many-to-Many Relationship: Assign professional cyclists to races

        tour.addCyclist(jonas);
        giro.addCyclist(roglic);
        vuelta.addCyclist(sepp);
        parisRoubaix.addCyclist(mvdp);
        amstel.addCyclist(pogi);
        tourOfFlanders.addCyclist(pogi);
        msr.addCyclist(mvdp);
        gentWevelgem.addCyclist(wout);
        tourOfBelgium.addCyclist(mvdp);
        uciWorldChamps.addCyclist(mvdp);
    }
}


