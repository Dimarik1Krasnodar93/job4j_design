package ru.job4j.ood.isp;

import org.checkerframework.common.util.report.qual.ReportOverride;

public class Notebook implements Devices {
    @Override
    public void powerMonitor() {
        System.out.println("Power monitor");
    }

    @Override
    public void lightKeyboard() {
        System.out.println("Light on keyboard");
    }
}
