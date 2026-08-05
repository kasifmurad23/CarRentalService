import java.util.*;

class CarRentalSystem {
    private ArrayList<Car> cars;
    private ArrayList<Customer> customers;
    private ArrayList<Rental> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addcar(Car car) {
        cars.add(car);
    }

    public void addcustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rent();
            Rental rental = new Rental(car, customer, days);
            rentals.add(rental);
        } else {
            System.out.println("Car is not available.");
        }
    }

    public void returnCar(Car car) {
        car.returnCar();
        Rental rentalToRemove = null;
        for (int i = 0; i < rentals.size(); i++) {
            Rental rental = rentals.get(i);
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }

        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
        } else {
            System.out.println("Car was not rented.");
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Car Rental System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice;
            try {
                 choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                continue;
            }
            if (choice == 1) {
                System.out.println("\n== Rent a Car ==\n");
                System.out.println("\nAvailable Cars:");
                for (int i = 0; i < cars.size(); i++) {
                    Car car = cars.get(i);
                    if (car.isAvailable()) {
                        System.out.println(car.getCarid() + " - " + car.getBrand() + " " + car.getModel());
                    }
                }

                System.out.print("\nEnter the car ID you want to rent: ");
                String carId = scanner.nextLine();
                Car selectedCar = null;
                for (int i = 0; i < cars.size(); i++) {
                    Car car = cars.get(i);
                    if (car.getCarid().equals(carId)) {
                        selectedCar = car;
                        break;
                    }
                }
                if (selectedCar == null) {
                    System.out.println("Invalid Car ID.");
                    continue;
                }
                if (!selectedCar.isAvailable()) {
                    System.out.println("Sorry! This car is already rented.");
                    continue;
                }
                System.out.print("Enter the number of days for rental: ");
                int rentalDays;
                try {
                    rentalDays = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Please enter valid rental days.");
                    scanner.nextLine();
                    continue;
                }
                System.out.print("Enter your name: ");
                String Name = scanner.nextLine();

                System.out.print("Enter Phone Number: ");
                String phoneNo = scanner.nextLine();

                System.out.print("Enter Email: ");
                String Email = scanner.nextLine();

                System.out.print("Enter Address: ");
                String Address = scanner.nextLine();

                System.out.print("Enter Driving License: ");
                String drivingLicense = scanner.nextLine();
                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), Name, phoneNo, Email, Address, drivingLicense);
                addcustomer(newCustomer);

                double totalPrice = selectedCar.CalculatePrice(rentalDays);

                System.out.println("\n== Rental Information ==\n");
                System.out.println("Customer ID: " + newCustomer.getCustomerId());
                System.out.println("Customer Name: " + newCustomer.getName());
                System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                System.out.println("Rental Days: " + rentalDays);
                System.out.println("Total Price: Rs" + totalPrice);

                System.out.print("\nConfirm rental (Y/N): ");
                String confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("Y")) {
                    rentCar(selectedCar, newCustomer, rentalDays);
                    System.out.println("\nCar rented successfully.");
                } else {
                    System.out.println("\nRental canceled.");
                }
            } else if (choice == 2) {
                System.out.println("\n== Return a Car ==\n");
                System.out.print("Enter the car ID you want to return: ");
                String carId = scanner.nextLine();

                Car carToReturn = null;
                for (int i = 0; i < cars.size(); i++) {
                    Car car = cars.get(i);
                    if (car.getCarid().equals(carId) && !car.isAvailable()) {
                        carToReturn = car;
                        break;
                    }
                }

                if (carToReturn != null) {
                    Customer customer = null;
                    for (int i = 0; i < rentals.size(); i++) {
                        Rental rental = rentals.get(i);
                        if (rental.getCar() == carToReturn) {
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if (customer != null) {
                        returnCar(carToReturn);
                        System.out.println("Car returned successfully by " + customer.getName());
                    } else {
                        System.out.println("Car was not rented or rental information is missing.");
                    }
                } else {
                    System.out.println("Invalid car ID or car is not rented.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        System.out.println("\nThank you for using the Car Rental System!");
    }

}

