package ru.job4j.ood.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ReportEngineAccountantTest {

    @Test
    void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Employee worker2 = new Employee("Max", now, now, 300);
        store.add(worker2);
        Report engine = new ReportEngineAccountant(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(FormatOutput.SEPARATOR)
                .append(worker2.getName()).append(";")
                .append(String.format(FormatOutput.DOUBLE_FORMAT, worker2.getSalary() * 0.87)).append(";")
                .append(FormatOutput.SEPARATOR)
                .append(worker.getName()).append(";")
                .append(String.format(FormatOutput.DOUBLE_FORMAT, worker.getSalary() * 0.87)).append(";")
                .append(FormatOutput.SEPARATOR);
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());

    }
}