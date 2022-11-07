package ru.job4j.ood.srp;

import ru.job4j.ood.srp.design.store.Store;
import ru.job4j.ood.srp.design.model.Employee;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FormatOutput {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");
    public static final String SEPARATOR  = System.lineSeparator();
    public static final String DOUBLE_FORMAT = "%.2f";
    private FormatOutput() {

    }

    public static class MemStore implements Store {

        private final List<Employee> employees = new ArrayList<>();

        @Override
        public void add(Employee em) {
            employees.add(em);
        }

        @Override
        public List<Employee> findBy(Predicate<Employee> filter) {
            return employees.stream().filter(filter).collect(Collectors.toList());
        }

    }
}
