package ru.job4j.io;
import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for(int i = 0; i <= 9; i++) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
