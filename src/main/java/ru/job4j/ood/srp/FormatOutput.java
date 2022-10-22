package ru.job4j.ood.srp;

import java.text.SimpleDateFormat;

public class FormatOutput {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");
    public static final String SEPARATOR  = System.lineSeparator();
    public static final String DOUBLE_FORMAT = "%.2f";
    private FormatOutput() {

    }
}
