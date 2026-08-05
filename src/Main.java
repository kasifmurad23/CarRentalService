import java.util.*;
public class Main{
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        Car car1 = new Car("C001", "TOYOTA", "FORTUNER", 200.0);
        Car car2 = new Car("C002", "HYNDAI", "VERNA", 100.0);
        Car car3 = new Car("C003", "MAHINDRA", "Thar", 150.0);
        rentalSystem.addcar(car1);
        rentalSystem.addcar(car2);
        rentalSystem.addcar(car3);
        rentalSystem.menu();

    }
}

