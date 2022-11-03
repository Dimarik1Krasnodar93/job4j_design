package ru.job4j.ood.lsp.parking;

public class Parking implements ParkingSizes {
    private int sizeCar;
    private int busyCars;
    private int sizeTrack;
    private int busyTrack;
    private int carCount = 0;
    private int trackCount = 0;

    Parking() {

    }

    Parking(int sizeCar, int sizeTrack) {
        this.sizeCar = sizeCar;
        this.sizeTrack = sizeTrack;
    }

    @Override
    public boolean parkCar(Car car) {
        boolean result = false;
        if (car.getSize() == 1) {
            if (busyCars < sizeCar) {
                busyCars++;
                carCount++;
                result = true;
            }
        } else {
            if (busyTrack < sizeTrack) {
                busyTrack++;
                trackCount++;
                result = true;
            } else {
               if (busyCars + car.getSize() <= sizeCar) {
                   busyCars = busyCars + car.getSize();
                   trackCount++;
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

    @Override
    public int getSizeCar() {
        return sizeCar;
    }

    @Override
    public int getEmptyCountCar() {
        return sizeCar - busyCars;
    }

    @Override
    public int getSizeTrack() {
        return sizeTrack;
    }


    @Override
    public int getEmptyCountTrack() {
        return sizeTrack - busyTrack;
    }
}
