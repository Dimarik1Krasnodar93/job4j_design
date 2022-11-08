package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ParkingTest {

    @Test
    void testTwoCarsSixTrack() {
        Park parking = new Park(1, 5);
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
        Park parking = new Park(7, 0);
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

    @Test
    void testTwoCarsOneTrack() {
        Park parking = new Park(4, 0);
        Car motocar1 = new MotorCar();
        Car motocar2 = new MotorCar();
        Track track = new Track(3);
        parking.parkCar(motocar1);
        parking.parkCar(motocar2);
        boolean trackParked = parking.parkCar(track);
        boolean expected = false;
        assertThat(trackParked).isEqualTo(expected);
    }

    @Test
    void testTrackAndTrackSize2() {
        Park parking = new Park(0, 3);
        Track track1 = new Track(6);
        Track track2 = new Track(2);
        parking.parkCar(track1);
        parking.parkCar(track2);
        boolean trackParked = parking.parkCar(track2);
        boolean expected = true;
        assertThat(trackParked).isEqualTo(expected);
    }

    @Test
    void testTrackAndTrackSizeException() {
        Park parking = new Park(0, 3);
        assertThatThrownBy(() -> new Track(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void withoughtPlaceseOnParking() {
        Park parking = new Park(0, 0);
        Track track1 = new Track(6);
        boolean trackParked = parking.parkCar(track1);
        boolean expected = false;
        assertThat(trackParked).isEqualTo(expected);
    }


}