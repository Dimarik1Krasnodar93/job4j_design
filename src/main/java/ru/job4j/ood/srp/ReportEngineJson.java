package ru.job4j.ood.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngineJson implements Report  {

    private final Store store;

    private Gson gson;

    public ReportEngineJson(Store store) {
        this.store = store;
        init();
    }

    private void init() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return gson.toJson(store.findBy(filter));
    }
}
