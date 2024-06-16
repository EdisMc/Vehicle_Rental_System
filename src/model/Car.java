package model;

public class Car extends Vehicle {

    private final int safetyRating;

    public Car(String brand, String model, double value, int safetyRating) {
        super(brand, model, value);
        this.safetyRating = safetyRating;
    }

    @Override
    public double getRentalCostPerDay(int rentalDays) {
        return rentalDays > 7 ? 15.00 : 20.00;
    }

    @Override
    public double getInsuranceCostPerDay() {
        double baseInsurance = value * 0.0001;
        if (safetyRating >= 4) {
            return baseInsurance * 0.90;
        }
        return baseInsurance;
    }

    public double getInitialInsuranceCostPerDay() {
        return value * 0.0001;
    }

    public double getInsuranceDiscountPerDay() {
        if (safetyRating >= 4) {
            return getInitialInsuranceCostPerDay() * 0.10;
        }
        return 0.0;
    }

}