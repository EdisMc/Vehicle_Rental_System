package model;

public class CargoVan extends Vehicle {

    private final int driverExperience;

    public CargoVan(String brand, String model, double value, int driverExperience) {
        super(brand, model, value);
        this.driverExperience = driverExperience;
    }

    @Override
    public double getRentalCostPerDay(int rentalDays) {
        return rentalDays > 7 ? 40.00 : 50.00;
    }

    @Override
    public double getInsuranceCostPerDay() {
        double baseInsurance = value * 0.0003;
        if (driverExperience > 5) {
            return baseInsurance * 0.85;
        }
        return baseInsurance;
    }

    public double getInitialInsuranceCostPerDay() {
        return value * 0.0003;
    }

    public double getInsuranceDiscountPerDay() {
        if (driverExperience > 5) {
            return getInitialInsuranceCostPerDay() * 0.15;
        }
        return 0.0;
    }

}
