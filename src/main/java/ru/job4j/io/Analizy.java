package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(target)));
            String temp = in.readLine();
            String[] strSplit;
            boolean isError = false;
            while (temp != null) {
                strSplit = temp.split(" ");
                if (strSplit[0].equals("400") || strSplit[0].equals("500")) {
                    if (!isError) {
                        isError = true;
                        out.print(strSplit[1]);
                        System.out.print(strSplit[1]);
                    }
                } else {
                    if (isError) {
                        out.println(";" + strSplit[1]);
                        System.out.println(";" + strSplit[1]);
                        isError = false;
                    }
                }
                temp = in.readLine();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("unavailable.csv", "target.csv");
    }
}
