package main;

import java.util.ArrayList;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private ArrayList<Driver> drivers;
    private ArrayList<RallyRaceResult> results;
    private static int totalDrivers = 0;
    private static int totalRaces = 0;

    private ChampionshipManager() {
        this.drivers = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    // we have to make sure that there is only 1 instance 
    public static ChampionshipManager getInstance(){
        if (instance == null){
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver){
        drivers.add(driver);
        totalDrivers++;
    }

    public void addRaceResult(RallyRaceResult result){
        results.add(result);
        totalRaces++;
    }

    public static ArrayList<Driver> getDriverStandings(){
        ArrayList<Driver> standings = new ArrayList<>();

        for (int i=0; i<instance.getDrivers().size(); i++){
            Driver nextDriver = new Driver(null, null, null);
            int maxPoint = 0;
            
            for (Driver driver : instance.getDrivers()) {
                // skip if it is in the list
                if (standings.contains(driver)){
                    continue;
                }
                
                if(driver.getPoints()>maxPoint){
                    nextDriver = driver;
                    maxPoint= driver.getPoints();
                } 
            
            }

            standings.add(nextDriver);
        
        }

        return standings;
    }

    public static Driver getLeadingDriver(){
        return ChampionshipManager.getDriverStandings().get(0);
    }

    public static int getTotalChampionshipPoints(){
        int totalPoints = 0;
        for (Driver driver : instance.getDrivers()) {
            totalPoints+=driver.getPoints();
        }

        return totalPoints;
    }

    static int getTotalRaces(){
        return totalRaces;
    }

    static int getTotalDrivers(){
        return totalDrivers;
    }

    public ArrayList<Driver> getDrivers(){
        return this.drivers;
    }

    public static void displayStandings(){
        ArrayList<Driver> standings = ChampionshipManager.getDriverStandings();
        int i=1;
        for (Driver driver : standings) {
            String name = driver.getName();
            String country = " (" + driver.getCountry() + "): ";
            String points = driver.getPoints() + " points";
            System.out.println(i + ". " + name + country + points);
            i++;
        }
    }

    public void displayResults(){
        for (RallyRaceResult result : this.results) {
            result.displayResults();
        }
    }

}
