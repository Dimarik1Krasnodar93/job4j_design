package ru.job4j.ood.isp;

public interface Cars {
    void drive();
    void setPetrol(double d);
    double getPetrol();
    double getFuelTank();
    void setFuelTank(double fuelTank);
    int getMaxSpeed(int countPassengeers);
}
