package ru.job4j.ood.lsp.parking;

public class Track extends Car {
    public Track() {
        size = 2;
    }

    public Track(int size) {
        validation(size);
        this.size = size;
    }

    private void validation(int size) {
        if (size <= MotorCar.CAR_SIZE) {
            throw new IllegalArgumentException("Illegal size");
        }
    }
}
