package ru.job4j.ood.srp.design.report;

import ru.job4j.ood.srp.design.model.Employee;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
}