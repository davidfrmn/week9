package main;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class RallyChampionship 
{
    public static void main( String[] args )
    {
        // car and driver data
        GravelCar gravelCar = new GravelCar("Ford", "Mustang", 400, 47);
        AsphaltCar asphaltCar = new AsphaltCar("Toyota", "Supra", 462, 20);
        
        Driver sebastianDriver = new Driver("Sébastien Ogier", "France", asphaltCar);
        Driver kalleDriver = new Driver("Kalle Rovanperä", "Finland", asphaltCar);
        Driver ottDriver = new Driver("Ott Tänak", "Estonia", asphaltCar);
        Driver thierryDriver = new Driver("Thierry Neuville", "Belgium", asphaltCar);

        ChampionshipManager championshipManager = ChampionshipManager.getInstance();

        //register drivers
        championshipManager.registerDriver(sebastianDriver);
        championshipManager.registerDriver(kalleDriver);
        championshipManager.registerDriver(ottDriver);
        championshipManager.registerDriver(thierryDriver);

        // first race
        RallyRaceResult firstRaceResult = new RallyRaceResult("Rally Finland", "Jyväskylä");
        firstRaceResult.recordResult(sebastianDriver, 1, 25);
        firstRaceResult.recordResult(ottDriver, 2, 18);
        firstRaceResult.recordResult(kalleDriver, 3, 15);
        firstRaceResult.recordResult(thierryDriver, 4, 12);

        //change car
        for (Driver driver : championshipManager.getDrivers()) {
            driver.setCar(gravelCar);
        }
        //sebastianDriver.setCar(gravelCar);
        //ottDriver.setCar(gravelCar);
        //kalleDriver.setCar(gravelCar);
        //thierryDriver.setCar(gravelCar);

        // second race
        RallyRaceResult secondRaceResult = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        secondRaceResult.recordResult(sebastianDriver, 3, 15);
        secondRaceResult.recordResult(ottDriver, 4, 12);
        secondRaceResult.recordResult(kalleDriver, 1, 25);
        secondRaceResult.recordResult(thierryDriver, 2, 18);

        //register races
        championshipManager.addRaceResult(firstRaceResult);
        championshipManager.addRaceResult(secondRaceResult);

        ChampionshipManager.displayStandings();
        
        System.out.println("\n===== CHAMPOINSHIP LEADER =====");
        Driver leadingDriver = ChampionshipManager.getLeadingDriver();
        System.out.println(leadingDriver.getName() + " with " + leadingDriver.getPoints() + " points");

        System.out.println("\n====== CHAMPOINSHIP STATISTICS =====");
        ArrayList<Driver> drivers = championshipManager.getDrivers();
        System.out.println("Total Drivers: " + ChampionshipStatistics.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.getTotalRacesHeld());
        System.out.println("Average Poinst Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(drivers));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(drivers));
        System.out.println("Total Championship Points: " + ChampionshipStatistics.getTotalChampionshipPoints());

        System.out.println("\n===== RACE RESULTS =====");
        championshipManager.displayResults();
        //firstRaceResult.displayResults();
        //secondRaceResult.displayResults();

        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + Double.toString(gravelCar.calculatePerformance()));
        System.out.println("Asphalt Car Performance: " + Double.toString(asphaltCar.calculatePerformance()));
    }

}


