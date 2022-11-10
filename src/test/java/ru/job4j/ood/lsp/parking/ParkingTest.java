package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class ParkingTest {

    @Test
    void testTwoCarsSixTrack() {
        Park parking = new Park(1, 2);
        parking.parkCar(new MotorCar());
        assertThat(parking.parkCar(new MotorCar())).isFalse();
        parking.parkCar(new Track(2));
        assertThat(parking.parkCar(new Track(5))).isFalse();
    }

    @Test
    void testOneCarThreeTrack() {
        Park parking = new Park(5, 0);
        Car motocar1 = new MotorCar();
        Car track1 = new Track(2);
        Car track2 = new Track(2);
        parking.parkCar(motocar1);
        parking.parkCar(track1);
        parking.parkCar(track2);
        int expectedCars = 1;
        int expectedTracks = 2;
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
        assertThat(trackParked).isFalse();
    }
}