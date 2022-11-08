package ru.job4j.ood.isp;

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

    @Override
    public int getMaxSpeed(int countPassengeers) {
        int result = 160;
        if (countPassengeers > 2) {
            result = 90;
        }
        if (petrol < 2) {
            result = 30;
        }
        return result;
    }

}
