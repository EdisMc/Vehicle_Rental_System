package service;

import model.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Invoice {

    public static void createInvoice(Rental rental) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println();
        System.out.println("XXXXXXXXXX");
        System.out.println("Date: " + LocalDate.now().format(formatter));
        System.out.println("Customer Name: " + rental.getCustomerName());
        System.out.println("Rented Vehicle: " + rental.getVehicle().getBrand() + " " + rental.getVehicle().getModel());
        System.out.println();
        System.out.println("Reservation start date: " + rental.getStartDate().format(formatter));
        System.out.println("Reservation end date: " + rental.getEndDate().format(formatter));
        System.out.println("Reserved rental days: " + rental.getReservedDays() + " days");
        System.out.println();
        System.out.println("Actual return date: " + rental.getActualReturnDate().format(formatter));
        System.out.println("Actual rental days: " + rental.getActualDays() + " days");
        System.out.println();
        System.out.println("Rental cost per day: $" + String.format("%.2f", rental.getVehicle().getRentalCostPerDay((int) rental.getReservedDays())));

        if (rental.getVehicle() instanceof Car car) {
            if (car.getInsuranceDiscountPerDay() > 0) {
                System.out.println("Insurance discount per day: $" + String.format("%.2f", car.getInsuranceDiscountPerDay()));
            }
        } else if (rental.getVehicle() instanceof Motorcycle motorcycle) {
            System.out.println("Initial insurance per day: $" + String.format("%.2f", motorcycle.getInitialInsuranceCostPerDay()));
            if (motorcycle.getInsuranceAdditionPerDay() > 0) {
                System.out.println("Insurance addition per day: $" + String.format("%.2f", motorcycle.getInsuranceAdditionPerDay()));
            }
        } else if (rental.getVehicle() instanceof CargoVan cargoVan) {
            System.out.println("Initial insurance per day: $" + String.format("%.2f", cargoVan.getInitialInsuranceCostPerDay()));
            if (cargoVan.getInsuranceDiscountPerDay() > 0) {
                System.out.println("Insurance discount per day: $" + String.format("%.2f", cargoVan.getInsuranceDiscountPerDay()));
            }
        }

        System.out.println("Insurance per day: $" + String.format("%.2f", rental.getVehicle().getInsuranceCostPerDay()));

        if (rental.getReservedDays() > rental.getActualDays()) {
            double earlyReturnDiscountForRent = (rental.getReservedDays() - rental.getActualDays()) * rental.getVehicle().getRentalCostPerDay((int) rental.getReservedDays()) / 2;
            double earlyReturnDiscountForInsurance = (rental.getReservedDays() - rental.getActualDays()) * rental.getVehicle().getInsuranceCostPerDay();
            System.out.println();
            System.out.println("Early return discount for rent: $" + String.format("%.2f", earlyReturnDiscountForRent));
            System.out.println("Early return discount for insurance: $" + String.format("%.2f", earlyReturnDiscountForInsurance));
        }

        System.out.println();
        System.out.println("Total rent: $" + String.format("%.2f", rental.calculateTotalRentalCost()));
        System.out.println("Total insurance: $" + String.format("%.2f", rental.calculateTotalInsuranceCost()));
        System.out.println("Total: $" + String.format("%.2f", rental.calculateTotalCost()));
        System.out.println("XXXXXXXXXX");
    }

}
