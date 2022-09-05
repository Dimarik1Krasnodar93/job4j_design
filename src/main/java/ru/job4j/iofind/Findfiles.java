package ru.job4j.iofind;

import org.slf4j.LoggerFactory;
import ru.job4j.io.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import org.slf4j.*;

public class Findfiles {
    private static final Logger LOG = LoggerFactory.getLogger(Findfiles.class.getName());
    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(args);
        validate(args, jvm);
        System.setProperty("log,name", jvm.get("o"));
        LOG.debug("Start");
        Predicate<Path> condition = getCondition(jvm);
        Path root = Paths.get(jvm.get("d"));
        LOG.debug("Start search");
        List<Path> lp = search(root, condition);
        LOG.debug("Finish search");
        for (Path temp : lp) {
            LOG.debug(temp.toString());
        }
    }

    private static Predicate<Path> getCondition(ArgsName jvm) {
        Predicate<Path> condition =  new Predicate<Path>() {
            @Override
            public boolean test(Path path) {
                return false;
            }
        };
        String searchText = jvm.get("n");
        String typeSearch = jvm.get("t");
        if ("regEx".equals(typeSearch)) {
            Pattern pattern = Pattern.compile(searchText);
            condition = i -> Pattern.matches(searchText, i.getFileName().toString());
        } else if ("mask".equals(typeSearch)) {
            condition = i -> i.getFileName().toString().contains(searchText);
        } else if ("name".equals(typeSearch)) {
            condition = i -> i.getFileName().toString().equals(searchText);
        } else {
            throw new IllegalArgumentException(String.format("Illegal argument -n: %s", typeSearch));
        }
        return condition;
    }

    private static List<Path> search(Path path, Predicate<Path> condition) {
        SearchFiles searcher = new SearchFiles(condition);
        try {
            LOG.debug("Start wolfFileTree");
            Files.walkFileTree(path, searcher);
        } catch (IOException ex) {
            LOG.error("IOException, ", ex);
        }
        return searcher.getPaths();

    }

    private static void validate(String[] args, ArgsName jvm) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Agrs count should be more than 2");
        }
        if (!jvm.contains("d")) {
            throw new IllegalArgumentException("jvm does not contain arg -d");
        }
        if (!jvm.contains("n")) {
            throw new IllegalArgumentException("jvm does not contain arg -n");
        }
        if (!jvm.contains("t")) {
            throw new IllegalArgumentException("jvm does not contain arg -t");
        }
        if (!jvm.contains("o")) {
            throw new IllegalArgumentException("jvm does not contain arg -o");
        }
    }
}
