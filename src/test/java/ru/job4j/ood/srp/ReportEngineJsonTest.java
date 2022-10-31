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
        expect.append(FormatOutput.SEPARATOR);
        expect.append("{");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"name\": ");
        expect.append("\"");
        expect.append(worker.getName());
        expect.append("\",");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"hired\": {");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"year\": ");
        expect.append(worker.getHired().get(Calendar.YEAR));
        expect.append(",");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"month\": ");
        expect.append(worker.getHired().get(Calendar.MONTH));
        expect.append(",");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"dayOfMonth\": ");
        expect.append(worker.getHired().get(Calendar.DATE));
        expect.append(",");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"hourOfDay\": ");
        expect.append(worker.getHired().get(Calendar.HOUR_OF_DAY));
        expect.append(",");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"minute\": ");
        expect.append(worker.getHired().get(Calendar.MINUTE));
        expect.append(",");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"second\": ");
        expect.append(worker.getHired().get(Calendar.SECOND));
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t},");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"fired\"");
        expect.append(": {");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"year\": ");
        expect.append(worker.getFired().get(Calendar.YEAR));
        expect.append(",");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"month\": ");
        expect.append(worker.getFired().get(Calendar.MONTH));
        expect.append(",");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"dayOfMonth\": ");
        expect.append(worker.getFired().get(Calendar.DATE));
        expect.append(",");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"hourOfDay\": ");
        expect.append(worker.getFired().get(Calendar.HOUR_OF_DAY));
        expect.append(",");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"minute\": ");
        expect.append(worker.getFired().get(Calendar.MINUTE));
        expect.append(",");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"second\": ");
        expect.append(worker.getFired().get(Calendar.SECOND));
        expect.append(FormatOutput.SEPARATOR);
        expect.append("    },");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\t\"salary\": ");
        expect.append(worker.getSalary());
        expect.append(FormatOutput.SEPARATOR);
        expect.append("  }");
        expect.append(FormatOutput.SEPARATOR);
        expect.append("\r]");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}
