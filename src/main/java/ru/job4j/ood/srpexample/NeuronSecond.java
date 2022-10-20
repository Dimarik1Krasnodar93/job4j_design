package ru.job4j.ood.srpexample;

public class NeuronSecond {
    private double weight;
    private boolean active;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public NeuronSecond(double weight, boolean active) {
        this.weight = weight;
        this.active = active;
    }

}
