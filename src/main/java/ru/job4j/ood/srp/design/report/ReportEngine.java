package ru.job4j.ood.srp.design.report;

import ru.job4j.ood.srp.FormatOutput;
import ru.job4j.ood.srp.design.store.Store;
import ru.job4j.ood.srp.design.model.Employee;

import javax.xml.bind.annotation.XmlAttribute;
import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class ReportEngine implements Report {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @XmlAttribute
    private final Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(FormatOutput.SEPARATOR);
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(FormatOutput.SEPARATOR);
        }
        return text.toString();
    }

}
