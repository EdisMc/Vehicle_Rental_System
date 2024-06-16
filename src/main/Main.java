package main;

import model.*;
import service.Invoice;
import util.DateUtil;

public class Main {

    public static void main(String[] args) {
        Vehicle car = new Car("Mitsubishi", "Mirage", 15000.00, 3);
        Rental rental1 = new Rental(car, "John Doe", DateUtil.parseDate("2024-06-03"), DateUtil.parseDate("2024-06-13"), DateUtil.parseDate("2024-06-13"));
        Invoice.createInvoice(rental1);

        Vehicle motorcycle = new Motorcycle("Triumph", "Tiger Sport 660", 10000.00, 20);
        Rental rental2 = new Rental(motorcycle, "Mary Johnson", DateUtil.parseDate("2024-06-03"), DateUtil.parseDate("2024-06-13"), DateUtil.parseDate("2024-06-13"));
        Invoice.createInvoice(rental2);

        Vehicle cargoVan = new CargoVan("Citroen", "Jumper", 20000.00, 8);
        Rental rental3 = new Rental(cargoVan, "John Mark", DateUtil.parseDate("2024-06-03"), DateUtil.parseDate("2024-06-18"), DateUtil.parseDate("2024-06-13"));
        Invoice.createInvoice(rental3);
    }

}
