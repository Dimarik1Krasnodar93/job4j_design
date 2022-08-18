package ru.job4j.io.duplicates;

import ru.job4j.set.Set;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {


    public Map<FileProperty, List<String>> hasMap = new HashMap<>();

    public DuplicatesVisitor() {

    }

    public Map<FileProperty, List<String>> getHasMap() {
        return hasMap;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        List<String> tempList = new ArrayList<>();
        tempList.add(file.toFile().getAbsolutePath());
        hasMap.merge(new FileProperty(file.toFile().length(),
                file.toFile().getName()), tempList, (oldV, newV) -> {
            oldV.add(file.toFile().getAbsolutePath());
            return oldV;
        });
        return super.visitFile(file, attrs);
    }
}