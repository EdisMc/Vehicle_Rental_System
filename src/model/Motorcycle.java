package model;

public class Motorcycle extends Vehicle {

    private final int riderAge;

    public Motorcycle(String brand, String model, double value, int riderAge) {
        super(brand, model, value);
        this.riderAge = riderAge;
    }

    @Override
    public double getRentalCostPerDay(int rentalDays) {
        return rentalDays > 7 ? 10.00 : 15.00;
    }

    @Override
    public double getInsuranceCostPerDay() {
        double baseInsurance = value * 0.0002;
        if (riderAge < 25) {
            return baseInsurance * 1.20;
        }
        return baseInsurance;
    }

    public double getInitialInsuranceCostPerDay() {
        return value * 0.0002;
    }

    public double getInsuranceAdditionPerDay() {
        if (riderAge < 25) {
            return getInitialInsuranceCostPerDay() * 0.20;
        }
        return 0.0;
    }

}
