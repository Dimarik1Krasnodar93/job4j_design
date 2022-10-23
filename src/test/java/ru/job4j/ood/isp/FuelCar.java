package ru.job4j.ood.isp;

public class FuelCar implements Car {
    @Override
    public void drive() {
        System.out.println("Drive car");
    }

    @Override
    public void refuelPetrol() {
        System.out.println("Fuel car");
    }

    @Override
    public void chargeBattery() {

    }
}
