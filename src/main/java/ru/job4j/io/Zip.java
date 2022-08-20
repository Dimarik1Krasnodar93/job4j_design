package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        for (Path path : sources) {
            File file = path.toFile();
            packSingleFile(file, target);
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
                zip.closeEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArgsName jvm = validateCreateArgsName(args);
        List<Path> lp = Search.search(Paths.get("."), x -> !x.endsWith(".class"));
        Zip zip = new Zip();
        zip.packFiles(lp, new File(jvm.get("o")));
    }

    public static ArgsName validateCreateArgsName(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Не введены все аргументы. Минимум 3 аргумента");
        }
        ArgsName jvm = ArgsName.of(args);
        String strPath = jvm.get("e");
        if (strPath == null) {
            throw new IllegalArgumentException("В аргументах отсутствует путь");
        }
        strPath = jvm.get("o");
        if (strPath == null) {
            throw new IllegalArgumentException("Отсутствует аргумент назначения");
        }
        return jvm;
    }
}
