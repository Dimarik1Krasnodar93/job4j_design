package ru.job4j.iofind;

import org.slf4j.LoggerFactory;
import ru.job4j.io.*;

import java.io.File;
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
    public static void main(String[] args) throws IOException {
        LOG.debug("Start");
        validate(args);
        ArgsName jvm = ArgsName.of(args);
        LOG.debug("validate:");
        LOG.debug(String.format("args:,  %s", args.toString()));
        Predicate<Path> condition = getCondition(jvm);
        Path root = Paths.get(jvm.get("d"));
        if (!root.toFile().isDirectory()) {
            throw new IOException("Path is not directory");
        }
        LOG.debug("Start search");
        List<Path> lp = search(root, condition);
        LOG.debug("Finish search");
        for (Path temp : lp) {
            LOG.debug(temp.toString());
        }
    }

    private static Predicate<Path> getCondition(ArgsName jvm) {
        Predicate<Path> condition;
        String searchText = jvm.get("n");
        String typeSearch = jvm.get("t");
        if ("regEx".equals(typeSearch)) {
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

    private static void validate(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Agrs count should be more than 4");
        }
    }
}
