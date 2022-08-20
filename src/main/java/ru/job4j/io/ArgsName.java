package ru.job4j.io;

import java.io.File;
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
        validate(args, false);
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        validate(args, true);
        ArgsName jvm = ArgsName.of(args);
        System.out.println(jvm.get("path"));
    }

    public static void validate(String[] args, boolean mainCheck) throws IllegalArgumentException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Отсутствуют аргументы");
        }
        String[] splitStr;
        splitStr = args[0].split("=", 2);
        if (mainCheck) {
            if (args.length < 2) {
                throw new IllegalArgumentException("Отсутствуют 2 обязательных аргумента");
            }
            File file = new File(splitStr[1]);
            if (!file.exists()) {
                throw new NoSuchFieldError(String.format("По указанному пути %s директория не обнаружена", splitStr[1]));
            }
            splitStr = args[1].split("=", 2);
            if (!splitStr[1].startsWith(".")) {
                throw new IllegalArgumentException(String.format("Второй параметр должен начинаться с ., значение %s", splitStr[1]));
            }
        }
    }
}
