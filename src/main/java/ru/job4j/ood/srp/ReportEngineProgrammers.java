package ru.job4j.ood.srp;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngineProgrammers implements Report {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    private Store store;

    public ReportEngineProgrammers(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>");
        text.append(System.lineSeparator());
        text.append("<head>Name; Hired; Fired; Salary;</head>")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
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
