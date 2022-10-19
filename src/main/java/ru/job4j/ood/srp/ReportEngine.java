package ru.job4j.ood.srp;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngine implements Report {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public String generateHtml(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>");
        text.append(System.lineSeparator());
        text.append("<head>Name; Hired; Fired; Salary;</head>")
                .append(System.lineSeparator());
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) Double.compare(o2.getSalary(), o1.getSalary());
            }
        };
        List<Employee> listEmployee = store.findBy(filter);
        listEmployee.sort(comparator);
        for (Employee employee : listEmployee) {
            text.append("<head>");
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("</head>")
                    .append(System.lineSeparator());
        }
        text.append("</html>");
        return text.toString();
    }
}
