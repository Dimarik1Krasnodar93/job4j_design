package ru.job4j.ood.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class ReportEngineJson implements Report  {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    private final Store store;



    public ReportEngineJson(Store store) {
        this.store = store;
        init();
    }

    private void init() {
       // gson = new GsonBuilder().create();
    }


    @Override
    public String generate(Predicate<Employee> filter) {
        String result = "";
        Gson gson = new GsonBuilder().create();
        result = gson.toJson(this);
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(FormatOutput.SEPARATOR);
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(FormatOutput.SEPARATOR);
        }
        return text.toString();
    }
}
