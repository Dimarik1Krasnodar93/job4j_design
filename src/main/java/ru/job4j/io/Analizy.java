package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(
                     new BufferedOutputStream(
                             new FileOutputStream(target)))) {
            String temp = "";
            String[] strSplit;
            boolean isError = false;
            while (in.ready()) {
                temp = in.readLine();
                strSplit = temp.split(" ");
                if ("400".equals(strSplit[0]) || "500".equals(strSplit[0])) {
                    if (!isError) {
                        isError = true;
                        out.print(strSplit[1]);
                    }
                } else {
                    if (isError) {
                        out.println(";" + strSplit[1]);
                        isError = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("unavailable.csv", "target.csv");
    }
}
