package ru.job4j.ood.srp;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngineHR implements Report {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    private Store store;

    public ReportEngineHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o2.getSalary(), o1.getSalary());
            }
        };
        List<Employee> listEmployee = store.findBy(filter);
        listEmployee.sort(comparator);
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : listEmployee) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

}
