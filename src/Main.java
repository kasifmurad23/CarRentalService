import java.util.*;
public class Main{
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        Car car1 = new Car("C001", "TOYOTA", "FORTUNER", 700.0);
        Car car2 = new Car("C002", "HYNDAI", "VERNA", 300.0);
        Car car3 = new Car("C003", "MAHINDRA", "Thar", 850.0);
        Car car4 = new Car("C004", "MERCEDES", "G-WAGON", 1500.0);
        Car car5 = new Car("C005", "TOYOTA", "INNOVA", 620.0);

        rentalSystem.addcar(car1);
        rentalSystem.addcar(car2);
        rentalSystem.addcar(car3);
        rentalSystem.addcar(car4);
        rentalSystem.addcar(car5);

        rentalSystem.menu();

    }
}

