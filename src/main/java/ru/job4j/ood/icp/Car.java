package ru.job4j.ood.icp;

public abstract class Car implements Cars {
    protected double petrol;



    protected double fuelTank;

    public double getPetrol() {
        return petrol;
    }

    @Override
    public void setPetrol(double petrol) {
        this.petrol = petrol;
    }

    public double getFuelTank() {
        return fuelTank;
    }

    public void setFuelTank(double fuelTank) {
        this.fuelTank = fuelTank;
    }

    public void drive() {
        if (petrol > 1) {
            System.out.println("You can drive");
        } else {
            System.out.println("You can't drive");
        }
    }

}
