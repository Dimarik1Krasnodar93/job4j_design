package ru.job4j.ood.isp;

public class ColorPrinter implements Printer {
    @Override
    public void printBlackWhite() {
        System.out.println("Black white print");
    }

    @Override
    public void printColor() {
        System.out.println("Color print");
    }
}
