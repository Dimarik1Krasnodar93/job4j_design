package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {
    public void unavailable(String source, String target) {
        Deque<StartEnd> deque = new LinkedList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String temp = in.readLine();
            StartEnd startEnd;
            String[] strSplit;
            while (temp != null) {
                startEnd = deque.pollLast();
                strSplit = temp.split(" ");
                if (startEnd == null || startEnd.end != null) {
                    if (strSplit[0].equals("400") || strSplit[0].equals("500")) {
                        if (startEnd != null) {
                            deque.add(startEnd);
                        }
                        startEnd = new StartEnd(strSplit[1]);
                    }
                } else {
                   if (!strSplit[0].equals("400") && !strSplit[0].equals("500")) {
                       startEnd.end = strSplit[1];
                   }
                }
                if (startEnd != null) {
                    deque.add(startEnd);
                }
                temp = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            for (StartEnd startEnd : deque) {
                out.println(startEnd.start + ";" + (startEnd.end == null ? "" : startEnd.end));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("unavailable.csv", "target.csv");
    }

    public class StartEnd {
        private String start;
        private String end;

        public StartEnd(String start) {
            this.start = start;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

    }
}
