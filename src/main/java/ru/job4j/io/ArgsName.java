package ru.job4j.io;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) throws  IllegalArgumentException {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("Argument not found");
        }
        String rsl = values.get(key);
        return rsl;
    }

    private void parse(String[] args) {
        String[] splitStr;
        for (String str : args) {
            validate(str);
            splitStr = str.split("=", 2);
            values.put(splitStr[0].substring(1), splitStr[1]);
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Отсутствуют аргументы");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(args);
        System.out.println(jvm.get("path"));
    }

    private static void validate(String str) {
        if (!str.startsWith("-")) {
            throw new IllegalArgumentException("First symbol should be '-'");
        }
        if (str.startsWith("-=")) {
            throw new IllegalArgumentException("String symbol should  not start by \"-=\"");
        }
        String[] splitStr;
        splitStr = str.split("=", 2);
        if (splitStr.length < 2) {
            throw new IllegalArgumentException("Illegal count arguments count after split");
        }
        if (splitStr[0].length() == 0 || splitStr[1].length() == 0) {
            throw new IllegalArgumentException("Length of one of arguments is 0");
        }
    }
}
