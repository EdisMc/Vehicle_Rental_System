package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rental {

    private final Vehicle vehicle;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final LocalDate actualReturnDate;
    private final String customerName;

    public Rental(Vehicle vehicle, String customerName, LocalDate startDate, LocalDate endDate, LocalDate actualReturnDate) {
        this.vehicle = vehicle;
        this.customerName = customerName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.actualReturnDate = actualReturnDate;
    }

    public long getReservedDays() {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    public long getActualDays() {
        return ChronoUnit.DAYS.between(startDate, actualReturnDate);
    }

    public double calculateTotalRentalCost() {
        long reservedDays = getReservedDays();
        long actualDays = getActualDays();

        double cost = 0.0;
        if (actualDays <= reservedDays) {
            cost += actualDays * vehicle.getRentalCostPerDay((int) actualDays);
            cost += (reservedDays - actualDays) * vehicle.getRentalCostPerDay((int) reservedDays) / 2;
        } else {
            cost += reservedDays * vehicle.getRentalCostPerDay((int) reservedDays);
        }
        return cost;
    }

    public double calculateTotalInsuranceCost() {
        long reservedDays = getReservedDays();
        long actualDays = getActualDays();

        double cost = 0.0;
        if (actualDays <= reservedDays) {
            cost += actualDays * vehicle.getInsuranceCostPerDay();
        } else {
            cost += reservedDays * vehicle.getInsuranceCostPerDay();
        }
        return cost;
    }

    public double calculateTotalCost() {
        return calculateTotalRentalCost() + calculateTotalInsuranceCost();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

}
