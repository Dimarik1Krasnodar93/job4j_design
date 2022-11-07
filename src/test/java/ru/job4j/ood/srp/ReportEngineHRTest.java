package ru.job4j.ood.srp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.design.model.Employee;
import ru.job4j.ood.srp.design.report.Report;
import ru.job4j.ood.srp.design.report.ReportEngineHR;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportEngineHRTest {
    @Test
    public void whenOldGenerated() {
        FormatOutput.MemStore store = new FormatOutput.MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Employee worker2 = new Employee("Max", now, now, 300);
        store.add(worker2);
        Report engine = new ReportEngineHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(FormatOutput.SEPARATOR)
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(FormatOutput.SEPARATOR);
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}