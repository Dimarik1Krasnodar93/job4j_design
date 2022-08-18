package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor dv = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), dv);
        dv.getHasMap().entrySet().forEach(i -> {
            if (i.getValue().size() > 1) {
                FileProperty fp = i.getKey();
                System.out.println(String.format("Name %s, size %d, list: %s", fp.getName(), fp.getSize(), i.getValue().toString()));
            }
            return;
        }
        );
    }
}