package ru.job4j.ood.lsp.parking;

public interface ParkingSizes {
    int getSizeCar();
    int getEmptyCountCar();
    int getSizeTrack();
    int getEmptyCountTrack();
    boolean parkCar(Car car);
    int getCars();
    int getTracks();
}