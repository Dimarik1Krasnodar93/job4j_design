package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Park implements Parking {
    private int sizeCar;
    private int busyCars;
    private int sizeTrack;
    private int busyTrack;
    private int carCount = 0;
    private int trackCount = 0;
    private List<Car> carList;
    private List<Car> trackList;

    public Park(int sizeCar, int sizeTrack) {
        this.sizeCar = sizeCar;
        this.sizeTrack = sizeTrack;
        carList = new ArrayList<>(sizeCar);
        trackList = new ArrayList<>(trackCount);
    }

    @Override
    public boolean parkCar(Car car) {
        boolean result = false;
        if (car.getSize() == MotorCar.CAR_SIZE && busyCars < sizeCar) {
            busyCars++;
            carCount++;
            carList.add(car);
            result = true;
        } else {
            if (busyTrack < sizeTrack) {
                busyTrack++;
                trackCount++;
                trackList.add(car);
                result = true;
            } else {
               if (busyCars + car.getSize() <= sizeCar) {
                   busyCars = busyCars + car.getSize();
                   trackCount++;
                   trackList.add(car);
                   result = true;
               }
            }
        }
        return result;
    }

    @Override
    public int getCars() {
        return carCount;
    }

    @Override
    public int getTracks() {
        return trackCount;
    }

}
