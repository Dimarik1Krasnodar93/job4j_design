package ru.job4j.io;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.*;
import java.nio.file.Path;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Disabled
class AnalizyTest {

    @Test
    void maintest(@TempDir Path tempDir) throws IOException {
        File target = tempDir.resolve("target.txt").toFile();
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter((source))) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("500 11:02:02");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader("target.csv"))) {
            in.lines().forEach(rsl::append);
        }
        String expected = "10:57:01;10:59:0111:01:02;11:02:02";
        assertThat(expected).isEqualTo(rsl.toString());
    }

}