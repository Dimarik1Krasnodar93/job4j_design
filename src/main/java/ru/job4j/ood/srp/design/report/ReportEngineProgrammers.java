package ru.job4j.ood.srp.design.report;

import ru.job4j.ood.srp.FormatOutput;
import ru.job4j.ood.srp.design.store.Store;
import ru.job4j.ood.srp.design.model.Employee;

import java.util.function.Predicate;

public class ReportEngineProgrammers implements Report {

    private Store store;

    public ReportEngineProgrammers(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>");
        text.append(FormatOutput.SEPARATOR);
        text.append("<head>Name; Hired; Fired; Salary;</head>")
                .append(FormatOutput.SEPARATOR);
        for (Employee employee : store.findBy(filter)) {
            text.append("<head>");
            text.append(employee.getName()).append(";")
                    .append(FormatOutput.DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(FormatOutput.DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("</head>")
                    .append(FormatOutput.SEPARATOR);
        }
        text.append("</html>");
        return text.toString();
    }
}
