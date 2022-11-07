package ru.job4j.ood.srp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.design.model.Employee;
import ru.job4j.ood.srp.design.report.Report;
import ru.job4j.ood.srp.design.report.ReportEngineXml;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportEngineXmlTest {
    private static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    @Test
    public void whenOldGenerated() {
        FormatOutput.MemStore store = new FormatOutput.MemStore();
        Calendar now = Calendar.getInstance();
        now.set(2022, 11, 1, 0, 0);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineXml(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employees>\n")
                .append("    <employees>\n")
                .append("        <fired>")
                .append(FORMATTER.format(worker.getFired().getTime()))
                .append("</fired>\n")
                .append("        <hired>")
                .append(FORMATTER.format(worker.getHired().getTime()))
                .append("</hired>\n")
                .append("        <name>")
                .append(worker.getName())
                .append("</name>\n")
                .append("        <salary>")
                .append(worker.getSalary())
                .append("</salary>\n")
                .append("    </employees>\n")
                .append("</employees>\n");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}