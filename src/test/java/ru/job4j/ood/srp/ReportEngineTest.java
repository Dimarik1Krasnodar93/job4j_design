package ru.job4j.ood.srp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.design.model.Employee;
import ru.job4j.ood.srp.design.report.Report;
import ru.job4j.ood.srp.design.report.ReportEngine;

import static org.assertj.core.api.Assertions.*;
import static ru.job4j.ood.srp.design.report.ReportEngine.DATE_FORMAT;

import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        FormatOutput.MemStore store = new FormatOutput.MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(FormatOutput.SEPARATOR)
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";")
                .append(FormatOutput.SEPARATOR);
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

}
