package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ParkingTest {

    @Test
    void testTwoCarsSixTrack() {
        Parking parking = new Parking(1, 5);
        Car motocar1 = new MotorCar();
        Car motocar2 = new MotorCar();
        Car track1 = new Track();
        Car track2 = new Track();
        Car track3 = new Track();
        Car track4 = new Track();
        Car track5 = new Track();
        Car track6 = new Track();
        parking.parkCar(motocar1);
        parking.parkCar(motocar2);
        parking.parkCar(track1);
        parking.parkCar(track2);
        parking.parkCar(track3);
        parking.parkCar(track4);
        parking.parkCar(track5);
        parking.parkCar(track6);
        int expectedCars = 1;
        int expectedTracks = 5;
        assertThat(parking.getCars()).isEqualTo(expectedCars);
        assertThat(parking.getTracks()).isEqualTo(expectedTracks);
    }

    @Test
    void testOneCarThreeTrack() {
        Parking parking = new Parking(7, 0);
        Car motocar1 = new MotorCar();
        Car track1 = new Track();
        Car track2 = new Track();
        Car track3 = new Track();
        Car track4 = new Track();
        Car track5 = new Track();
        Car track6 = new Track();
        parking.parkCar(motocar1);
        parking.parkCar(track1);
        parking.parkCar(track2);
        parking.parkCar(track3);
        parking.parkCar(track4);
        parking.parkCar(track5);
        parking.parkCar(track6);
        int expectedCars = 1;
        int expectedTracks = 3;
        assertThat(parking.getCars()).isEqualTo(expectedCars);
        assertThat(parking.getTracks()).isEqualTo(expectedTracks);
    }

}