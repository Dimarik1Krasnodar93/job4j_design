package ru.job4j.ood.icp;

public class Bus extends Car {

    @Override
    public void drive() {
        if (petrol > 5) {
            System.out.println("You can drive");
        } else {
            System.out.println("You can]t drive");
        }
    }

    @Override
    public int getMaxSpeed(int countPassengeers) {
        if (countPassengeers < 1) {
            throw new IllegalArgumentException("Incorrect count passengers");
        }
        return 160;
    }


}
