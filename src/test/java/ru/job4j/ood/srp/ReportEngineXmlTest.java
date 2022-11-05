package ru.job4j.ood.srp;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static ru.job4j.ood.srp.ReportEngine.DATE_FORMAT;

class ReportEngineXmlTest {
    private static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        now.set(2022, 11, 1, 0, 0);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineXml(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append(FormatOutput.SEPARATOR)
                .append("<employee>")
                .append(FormatOutput.SEPARATOR)
                .append("    <employees>")
                .append(FormatOutput.SEPARATOR)
                .append("        <fired>")
                .append(FORMATTER.format(worker.getFired().getTime()))
                .append("</fired>")
                .append(FormatOutput.SEPARATOR)
                .append("        <hired>")
                .append(FORMATTER.format(worker.getHired().getTime()))
                .append("</hired>")
                .append(FormatOutput.SEPARATOR)
                .append("        <name>")
                .append(worker.getName())
                .append("</name>")
                .append(FormatOutput.SEPARATOR)
                .append("        <salary>")
                .append(worker.getSalary())
                .append("</salary>")
                .append(FormatOutput.SEPARATOR)
                .append("    </employees>")
                .append(FormatOutput.SEPARATOR)
                .append("</employee>")
                .append(FormatOutput.SEPARATOR);
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}