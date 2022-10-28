package ru.job4j.ood.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static ru.job4j.ood.srp.ReportEngine.DATE_FORMAT;

class ReportEngineJsonTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineJson(store);
        StringBuilder expect = new StringBuilder();
        expect.append("[");
        expect.append("{");
        expect.append("\"name\":");
        expect.append("\"");
        expect.append(worker.getName());
        expect.append("\"");
        expect.append(",\"hired\":{");
        expect.append("\"year\":");
        expect.append(worker.getHired().get(Calendar.YEAR));
        expect.append(",\"month\":");
        expect.append(worker.getHired().get(Calendar.MONTH));
        expect.append(",\"dayOfMonth\":");
        expect.append(worker.getHired().get(Calendar.DATE));
        expect.append(",\"hourOfDay\":");
        expect.append(worker.getHired().get(Calendar.HOUR_OF_DAY));
        expect.append(",\"minute\":");
        expect.append(worker.getHired().get(Calendar.MINUTE));
        expect.append(",\"second\":");
        expect.append(worker.getHired().get(Calendar.SECOND));
        expect.append("},");
        expect.append("\"fired\"");
        expect.append(":{");
        expect.append("\"year\":");
        expect.append(worker.getFired().get(Calendar.YEAR));
        expect.append(",\"month\":");
        expect.append(worker.getFired().get(Calendar.MONTH));
        expect.append(",\"dayOfMonth\":");
        expect.append(worker.getFired().get(Calendar.DATE));
        expect.append(",\"hourOfDay\":");
        expect.append(worker.getFired().get(Calendar.HOUR_OF_DAY));
        expect.append(",\"minute\":");
        expect.append(worker.getFired().get(Calendar.MINUTE));
        expect.append(",\"second\":");
        expect.append(worker.getFired().get(Calendar.SECOND));
        expect.append("},");
        expect.append("\"salary\":");
        expect.append(worker.getSalary());
        expect.append("}]");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}
