package ru.job4j.ood.icp;

public class Testlcp {
    public static void main(String[] args) {
        Cars bus = new Bus();
        bus.setPetrol(4);
        bus.drive();
        getAveragePassegeers(bus);
        needMorePetrol(bus);
    }

    public static void getAveragePassegeers(Cars car) {
        if (car.getClass() == Bus.class) {
            System.out.println("More than 40 passangeers");
        } else if (car.getClass() == Car.class) {
            System.out.println("Less than 3 passangeers");
        }
    }

    public static void needMorePetrol(Cars car) {
        if (car.getPetrol() < 5) {
            System.out.println("For bus need more petrol");
        }
    }
}
