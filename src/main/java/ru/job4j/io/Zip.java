package ru.job4j.io;

import java.io.*;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<File> sources, File target) {

        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.putNextEntry(new ZipEntry(source.getPath()));
                    zip.write(out.readAllBytes());
                    zip.closeEntry();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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

    public static void main(String[] args) throws IOException {
        ArgsName jvm = validateCreateArgsName(args);
        List<File> lf = Search.searchFiles(Paths.get("."), x -> !x.endsWith(".class"));
        Zip zip = new Zip();
        zip.packFiles(lf, new File(jvm.get("o")));
    }

    public static ArgsName validateCreateArgsName(String[] args) throws IOException {
        if (args.length < 3) {
            throw new IllegalArgumentException("Не введены все аргументы. Минимум 3 аргумента");
        }
        ArgsName jvm = ArgsName.of(args);
        String temp = jvm.get("e");
        if (temp == null) {
            throw new IllegalArgumentException("Argument has not file extension");
        }
        if (!temp.startsWith(".")) {
            throw new IllegalArgumentException("Argument has not file extension - has not point");
        }
        temp = jvm.get("d");
        if (temp == null) {
            throw new IllegalArgumentException("Target argument has not found");
        }
        File file = new File(temp);
        if (!file.exists() || !file.isDirectory()) {
            throw new NotDirectoryException("Target argument has not found or target is not directory");
        }
        temp = jvm.get("o");
        if (temp == null) {
            throw new IllegalArgumentException("Target argument has not found");
        }
        if (!temp.endsWith("zip")) {
            throw new IllegalArgumentException("Target should ends with .zip");
        }
        return jvm;
    }
}
