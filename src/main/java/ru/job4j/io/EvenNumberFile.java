package ru.job4j.io;
import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String temp : lines) {
                System.out.println(temp + " " +  (Integer.parseInt(temp) % 2 == 0 ? "четное" : "нечетное"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
