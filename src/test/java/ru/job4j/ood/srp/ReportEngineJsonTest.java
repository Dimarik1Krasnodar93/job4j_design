package ru.job4j.ood.srp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.design.model.Employee;
import ru.job4j.ood.srp.design.report.Report;
import ru.job4j.ood.srp.design.report.ReportEngineJson;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportEngineJsonTest {
    @Test
    public void whenOldGenerated() {
        FormatOutput.MemStore store = new FormatOutput.MemStore();
        Calendar now = Calendar.getInstance();
        now.set(2022, 11, 1, 0, 0, 0);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineJson(store);
        String expect = "[\n"
                + "  {\n"
                + "    \"name\": \"Ivan\",\n"
                + "    \"hired\": {\n"
                + "      \"year\": 2022,\n"
                + "      \"month\": 11,\n"
                + "      \"dayOfMonth\": 1,\n"
                + "      \"hourOfDay\": 0,\n"
                + "      \"minute\": 0,\n"
                + "      \"second\": 0\n"
                + "    },\n"
                + "    \"fired\": {\n"
                + "      \"year\": 2022,\n"
                + "      \"month\": 11,\n"
                + "      \"dayOfMonth\": 1,\n"
                + "      \"hourOfDay\": 0,\n"
                + "      \"minute\": 0,\n"
                + "      \"second\": 0\n"
                + "    },\n"
                + "    \"salary\": 100.0\n"
                + "  }\n"
                + "]";
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}
