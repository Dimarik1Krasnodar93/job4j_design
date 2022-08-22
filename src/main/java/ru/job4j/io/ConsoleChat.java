package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> list = readPhrases();
        String strCycle = STOP;
        String temp = "";
        List<String> log = new LinkedList<>();
        while (strCycle != OUT) {
            if (strCycle == CONTINUE) {
                temp = list.get((int) (Math.random() * (list.size() - 1)));
                System.out.println(temp);
            }
            log.add("Пользователь ввел \"" + strCycle + "\"" +  (temp == CONTINUE ? " случайная строка " + temp : ""));
            strCycle = getUserInput();
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> rsl = new ArrayList<>(40);
        try (BufferedReader bf = new BufferedReader(new FileReader(path, Charset.forName("ASCII")))) {
            while (bf.ready()) {
                rsl.add(bf.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private String getUserInput() {
        Scanner sc = new Scanner(System.in);
        String strIn = sc.next();
        String rsl = CONTINUE;
        if (OUT.equals(strIn)) {
            rsl = OUT;
        } else if (STOP.equals(strIn)) {
            rsl = STOP;
        }
        return rsl;
    }

    private void saveLog(List<String> log) {
        try (FileWriter fw = new FileWriter(botAnswers)) {
            for (String temp : log) {
                fw.write(temp + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("Случайные_слова_файл.txt", "log.txt");
        cc.run();
    }
}