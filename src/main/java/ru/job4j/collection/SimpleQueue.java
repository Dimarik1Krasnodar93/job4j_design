package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int countOut = 0;
    int countIn = 0;
    public T poll() {
        if (countOut == 0) {
            for (int i = 0; i < countIn; i++) {
                out.push(in.pop());
                countOut++;
            }
        }
        countOut--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        countIn++;
    }
}