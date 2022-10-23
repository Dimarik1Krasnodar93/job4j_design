package ru.job4j.ood.srp;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngineAccountant implements Report {
    private final static double TAX_KOEFF = 0.87;
    private Store store;

    public ReportEngineAccountant(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> listEmployee = store.findBy(filter);
        listEmployee.sort(Comparator.comparing(Employee::getSalary).reversed());
        text.append("Name; Salary;")
                .append(FormatOutput.SEPARATOR);
        for (Employee employee : listEmployee) {
            text.append(employee.getName()).append(";")
                    .append(String.format(FormatOutput.DOUBLE_FORMAT, employee.getSalary() * TAX_KOEFF)).append(";")
                    .append(FormatOutput.SEPARATOR);
        }
        return text.toString();
    }


}
