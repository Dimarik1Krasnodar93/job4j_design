package ru.job4j.ood.srpexample;

import java.util.Random;

public class PerceptronNeuron implements Neuron {
    private double weight;
    private boolean ckeched;
    private double result;
    public PerceptronNeuron(double weight, boolean checked) {
         this.weight = weight;
         this.ckeched = checked;
    }

    @Override
    public void result() {
        result = ckeched ? weight : 0;
    }

    @Override
    public void outputResult() {
        System.out.println(String.format("result = %d", weight));
    }

    public double[] createRandomValues() {
        double[] weightArray = new double[10];
        Random random = new Random();
        for (int i = 0; i <  weightArray.length; i++) {
            weightArray[i] = random.nextDouble();
        }
        return weightArray;
    }
}
