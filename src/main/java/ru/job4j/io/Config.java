package ru.job4j.io;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Collectors;

public class Config {

    private final String path;
    private Map<String, String>  values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            values = in.lines()
                    .filter(x -> !x.startsWith("#") && x.length() > 0)
            .collect(Collectors
                    .toMap(k -> {
                            if (k.lastIndexOf("=") == -1) {
                                throw new IllegalArgumentException();
                            }
                        return k.substring(0, k.indexOf("=")); },
                            v -> {
                        if (v.lastIndexOf("=") == -1) {
                            throw new IllegalArgumentException();
                        }
                        return v.substring(v.lastIndexOf("=") + 1); }));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }
}
