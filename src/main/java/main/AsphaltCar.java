package main;

public class AsphaltCar extends RallyCar {
    private double downforce;

    public AsphaltCar(String make, String model, int horsepower, double downforce){
        super(make, model, horsepower);
        this.downforce=downforce;
    }

    public double getDownforce(){
        return this.downforce;
    }

    public double calculatePerformance(){
        return 0.5*downforce + this.getHorsepower();
    }
    
}
