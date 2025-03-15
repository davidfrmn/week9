package main;

import java.util.ArrayList;
import java.util.HashMap;

public class ChampionshipStatistics {
    
    public static double calculateAveragePointsPerDriver(ArrayList<Driver> drivers){
        double totalPoints = 0;
        int driverCounter = 0;
        
        for (Driver driver : drivers) {
            driverCounter++;
            totalPoints+=driver.getPoints();
        }

        return totalPoints/driverCounter;
    }

    public static String findMostSuccessfulCountry(ArrayList<Driver> drivers){
        // we create a hashmap with Country - totalPoints
        HashMap<String, Integer> countryStanding = new HashMap<>();
        
        for (Driver driver : drivers) {
            String country = driver.getCountry();
            int points = driver.getPoints();
            
            // we try to set a Country - Points pair
            // if the country is not yet in the HashMap then the getOrDefault returns zero and we add the new points
            // if the country is in the Hashmap we get their current points increase it by the new points and update the hasmap
            countryStanding.put(country, countryStanding.getOrDefault(country, 0)+ points);
        }


        String mostSuccessfulCountry="";
        int mostPoints=0;

        // we got through the hasmap and try to find the country with the most points
        for (String country : countryStanding.keySet()) {
            int points = countryStanding.get(country);
            if (points>mostPoints){
                mostPoints = points;
                mostSuccessfulCountry = country;
            }
        }
        
        return mostSuccessfulCountry;
    }

    static int getTotalRacesHeld(){
        return ChampionshipManager.getTotalRaces();
    }

    static int getTotalChampionshipPoints(){
        return ChampionshipManager.getTotalChampionshipPoints();
    }

    static int getTotalDrivers(){
        return ChampionshipManager.getTotalDrivers();
    }

}
