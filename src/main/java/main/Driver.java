package main;

public class Driver {
    private String name;
    private String country;
    private int points;
    private RallyCar car;

    public Driver(String name, String country, RallyCar car){
        this.name= name;
        this.country = country;
        this.car = car;
        this.points = 0;
    }

    public String getName(){
        return this.name;
    }

    public String getCountry(){
        return this.country;
    }

    public int getPoints(){
        return this.points;
    }

    public RallyCar getCar(){
        return this.car;
    }

    public void setCar(RallyCar car){
        this.car = car;
    }

    public void addPoints(int points){
        this.points+=points;
    }
    
}
