package ru.job4j.ood.srpexample;

public class NeuralNetwork {
    private NeuronSecond[] neurons;

    public NeuronSecond[] getNeurons() {
        return neurons;
    }

    public void setNeurons(NeuronSecond[] neurons) {
        this.neurons = neurons;
    }

    public NeuralNetwork(NeuronSecond[] neurons) {
        this.neurons = new NeuronSecond[neurons.length];
        for (int i = 0; i < neurons.length; i++) {
            this.neurons[i] = neurons[i];
        }
    }

    public double getNeuronWeight(int i) {
        return neurons[i].getWeight();
    }

}
