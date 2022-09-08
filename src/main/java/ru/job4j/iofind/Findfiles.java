package ru.job4j.iofind;

import org.slf4j.LoggerFactory;
import ru.job4j.io.*;

import java.io.*;
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
            LOG.error("Path is not directory");
            throw new IOException("Path is not directory");
        }
        LOG.debug("Start search");
        List<Path> lp = search(root, condition);
        LOG.debug("Finish search");
        outFile(jvm, lp);
    }

    private static void outFile(ArgsName jvm, List<Path> lp) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(jvm.get("o"))))) {
            for (Path p : lp) {
                out.println(p);
            }
        } catch (FileNotFoundException ex) {
            LOG.error(ex.toString());
        }
    }

    private static Predicate<Path> getCondition(ArgsName jvm) {
        Predicate<Path> condition;
        String searchText = jvm.get("n");
        String typeSearch = jvm.get("t");
        if ("regEx".equals(typeSearch)) {
            condition = i -> Pattern.compile(searchText).matcher(i.getFileName().toString()).find();
        } else if ("mask".equals(typeSearch)) {
            String searchText2 = searchText.replace(".", "[.]").replace("*", ".*").replace("?", ".");
            condition = i -> i.getFileName().toString().matches(searchText2);
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
