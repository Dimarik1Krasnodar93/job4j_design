package ru.job4j.ood.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static ru.job4j.ood.srp.ReportEngine.DATE_FORMAT;

class ReportEngineProgrammersTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker2 = new Employee("Ivan", now, now, 300);
        store.add(worker2);
        Employee worker = new Employee("Petr", now, now, 200);
        Report engine = new ReportEngineProgrammers(store);
        store.add(worker);
        StringBuilder expect = new StringBuilder()
                .append("<html>")
                .append(System.lineSeparator())
                .append("<head>Name; Hired; Fired; Salary;</head>")
                .append(System.lineSeparator())
                .append("<head>")
                .append(worker2.getName()).append(";")
                .append(DATE_FORMAT.format(worker2.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker2.getFired().getTime())).append(";")
                .append(worker2.getSalary()).append(";")
                .append("</head>")
                .append(System.lineSeparator())
                .append("<head>")
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";")
                .append("</head>")
                .append(System.lineSeparator())
                .append("</html>");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}