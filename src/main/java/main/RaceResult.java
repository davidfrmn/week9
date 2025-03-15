package main;

import java.util.ArrayList;

public interface RaceResult {
    public void recordResult(Driver driver, int position, int points);
    public int getDriverPoints(Driver driver);
    public ArrayList<Driver> getResults();
    
} 
