package ru.job4j.ood.srp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static ru.job4j.ood.srp.ReportEngine.DATE_FORMAT;

import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenOldGeneratedHtml() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Employee worker2 = new Employee("Petr", now, now, 200);
        Report engine = new ReportEngine(store);
        store.add(worker2);
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
        assertThat(engine.generateHtml(em -> true)).isEqualTo(expect.toString());
    }
}
