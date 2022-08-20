package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) throws  IllegalArgumentException {
        String rsl = values.get(key);
        if (rsl == null) {
            throw new IllegalArgumentException("Argument not found");
        } else {
            return rsl;
        }
    }

    private void parse(String[] args) {
        String[] splitStr;
        for (String str : args) {
            splitStr = str.split("=", 2);
            values.put(splitStr[0].substring(1), splitStr[1]);
        }
    }

    public static ArgsName of(String[] args) {
        validate(args);
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }

    public static void validate(String[] args) throws IllegalArgumentException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Отсутствуют аргументы");
        }
    }
}
