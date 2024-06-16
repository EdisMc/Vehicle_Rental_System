# Vehicle Rental System

## Overview
The project aims to design a simple yet functional vehicle rental system that manages the rental and return processes of different types of vehicles. The system calculates rental and insurance costs based on specific business rules and generates an invoice for the customer.

## Project Structure
The project is organized into several packages, each serving a specific purpose.

### Packages
- `main`: Contains the `Main.java` file which initializes the program with test data and generates invoices;
- `model`: Contains the classes representing the different types of vehicles (`Car`, `Motorcycle`, `CargoVan`) and the `Rental` class which holds rental information;
- `service`: Contains the `Invoice` class responsible for creating and printing the invoice;
- `util`: Contains the utility class `DateUtil` for date-related operations.

## Approach

### Vehicle Classes
The system handles three types of vehicles: `Car`, `Motorcycle`, and `CargoVan`, all inheriting from the abstract `Vehicle` class. Each vehicle class implements methods to calculate rental and insurance costs based on the specified business rules.

- **Car**: Includes an additional attribute for safety rating. The insurance cost is reduced by 10% for cars with a high safety rating (4 or 5).
- **Motorcycle**: Includes an attribute for the rider's age. The insurance cost is increased by 20% for riders under 25 years old.
- **CargoVan**: Includes an attribute for the driver's experience. The insurance cost is reduced by 15% for drivers with more than 5 years of experience.

### Rental Class
The `Rental` class stores all necessary information about the rental, including the customer name, vehicle, rental start and end dates, and the actual return date. It provides methods to calculate the total rental cost, total insurance cost, and the final total cost.

### Invoice Generation
The `Invoice` class in the `service` package generates and prints the invoice. It takes a `Rental` object and prints the details of the rental, including the rental and insurance costs per day, any applicable discounts, and the total costs.

### Early Return Discount
If a vehicle is returned earlier than the reserved period, the system applies a discount for the remaining days. The rental cost is charged at half the price for the remaining days, while the insurance cost is only charged for the actual days the vehicle was rented.
