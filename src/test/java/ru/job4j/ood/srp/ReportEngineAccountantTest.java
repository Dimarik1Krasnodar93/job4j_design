package ru.job4j.ood.srp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.design.model.Employee;
import ru.job4j.ood.srp.design.report.Report;
import ru.job4j.ood.srp.design.report.ReportEngineAccountant;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportEngineAccountantTest {

    @Test
    void whenOldGenerated() {
        FormatOutput.MemStore store = new FormatOutput.MemStore();
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
                .append(String.format(FormatOutput.DOUBLE_FORMAT, worker2.getSalary() * ReportEngineAccountant.TAX_KOEFF)).append(";")
                .append(FormatOutput.SEPARATOR)
                .append(worker.getName()).append(";")
                .append(String.format(FormatOutput.DOUBLE_FORMAT, worker.getSalary() * ReportEngineAccountant.TAX_KOEFF)).append(";")
                .append(FormatOutput.SEPARATOR);
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());

    }
}