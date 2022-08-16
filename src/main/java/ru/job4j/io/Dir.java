package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("pom.xml");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            System.out.println(String.format("name: %s; size: %d", file.getName(), file.length()));
        } else {
            for (File subfile : file.listFiles()) {
                System.out.println(subfile.getAbsoluteFile());
            }
        }
    }
}
