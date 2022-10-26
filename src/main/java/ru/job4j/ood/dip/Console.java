package ru.job4j.ood.dip;

public class Console implements Output {
    @Override
    public void out() {
        System.out.println("Message");
    }
}
