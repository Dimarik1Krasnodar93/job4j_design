package ru.job4j.ood.srp;

import ru.job4j.ood.srp.design.model.Employee;

import java.util.List;
import java.util.function.Predicate;

public interface Store {

    void add(Employee em);

    List<Employee> findBy(Predicate<Employee> filter);
}
