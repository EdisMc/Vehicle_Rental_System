package model;

public abstract class Vehicle {

    protected String brand;
    protected String model;
    protected double value;

    public Vehicle(String brand, String model, double value) {
        this.brand = brand;
        this.model = model;
        this.value = value;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public abstract double getRentalCostPerDay(int rentalDays);
    public abstract double getInsuranceCostPerDay();

}
