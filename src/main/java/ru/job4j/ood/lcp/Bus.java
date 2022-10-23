package ru.job4j.ood.lcp;

public class Bus extends Car {

    @Override
    public void drive() {
        if (petrol > 5) {
            System.out.println("You can drive");
        } else {
            System.out.println("You can]t drive");
        }
    }


}
