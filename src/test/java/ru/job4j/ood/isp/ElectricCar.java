package ru.job4j.ood.isp;

public class ElectricCar implements Car {
    @Override
    public void drive() {
        System.out.println("Drive car");
    }

    @Override
    public void refuelPetrol() {

    }

    @Override
    public void chargeBattery() {
        System.out.println("Charge Battery");
    }
}
