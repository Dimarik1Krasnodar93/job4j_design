package ru.job4j.ood.ocp;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class FileExample {
    private static class SimpleFile {
        private FileWriter filewriter;

        public SimpleFile(String path) throws IOException  {
            filewriter = new FileWriter(path);
        }

        public SimpleFile() {

        }

        public void addString(String str) throws IOException {
            filewriter.write(str);
            filewriter.flush();
        }

        public void addListString(List<String> liststr) throws IOException {
            for (String str : liststr) {
                filewriter.write(str);
            }
            filewriter.flush();
        }
    }

    private static class SimpleFileWithSubstring extends SimpleFile  {
        private FileWriter filewriter;

        public SimpleFileWithSubstring(String path) throws IOException  {
            filewriter = new FileWriter(path);
        }

        public void addString(String str) throws IOException {
            filewriter.write("substr" + str);
            filewriter.flush();
        }
    }

    private static class AbstractFile {
        private FileWriter filewriter;

        public AbstractFile(String path) throws IOException  {
            filewriter = new FileWriter(path);
        }

        public void fileConsumer(Consumer<FileWriter> consumer) {
            consumer.accept(filewriter);
        }

        public static void main(String[] args) throws IOException {
            AbstractFile abstractFile = new AbstractFile("C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\ood\\ocp\\example.txt");
            String example = "Test string";
            Consumer<FileWriter> consumerAdd  =  s -> {
                try {
                s.write(example);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            };
            abstractFile.fileConsumer(consumerAdd);
            abstractFile.filewriter.flush();

            SimpleFile simpleFile2 = new SimpleFile("C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\ood\\ocp\\example2.txt");
            simpleFile2.addString("1");
            SimpleFileWithSubstring simpleFile3 = new SimpleFileWithSubstring("C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\ood\\ocp\\example3.txt");
            simpleFile3.addString("1");
        }

    }
}
