package main;

import java.util.ArrayList;
import java.util.HashMap;

public class RallyRaceResult implements RaceResult{
    private String raceName;
    private String location;
    private HashMap<Driver, Integer> results;

    public RallyRaceResult(String raceName,String location){
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>();
    }

    public String getRaceName(){
        return this.raceName;
    }

    public String getLocation(){
        return this.location;
    }

    @Override
    public void recordResult(Driver driver, int position, int points){
        this.results.put(driver, points);
        driver.addPoints(points);
    }

    @Override
    public int getDriverPoints(Driver driver){
        return this.results.get(driver);
    }

    @Override
    public ArrayList<Driver> getResults(){
        // we return the drivers in order
        ArrayList<Driver> order = new ArrayList<>();
        int noDrivers = this.results.keySet().size();
        
        // we check for the next driver by itertating through the results muliple times
        for (int i=1;i<=noDrivers;i++){
            Driver nextDriver = new Driver(raceName, location, null);
            int mostPoints = 0;
            
            for (Driver driver : this.results.keySet()) {
                //skip if we have already examined the driver
                if (order.contains(driver)){
                    continue;
                }
                
                // if current driver has more points then set him as the next driver
                int points = this.results.get(driver);
                if(points>mostPoints){
                    nextDriver = driver;
                    mostPoints = points;
                }
            }

            order.add(nextDriver);
        }

        return order;
    }

    public void displayResults(){
        System.out.println("Race: " + this.getRaceName() + " (" + this.getLocation() + ")");
        ArrayList<Driver> result = this.getResults();
        int position = 1;
        for (Driver driver : result) {
            String name = driver.getName();
            int points = this.getDriverPoints(driver);
            System.out.print("\tPosition " + position + ": ");
            System.out.println(name + " - " + points);
            position++;
        }
        System.out.println();
    }
}
