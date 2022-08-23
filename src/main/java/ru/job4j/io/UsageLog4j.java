package ru.job4j.io;

import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);
        double height = 174.5d;
        LOG.debug("User info height : {}", height);
        float weight = 79.55f;
        LOG.debug("User info weight : {}", weight);
        boolean isMale = true;
        LOG.debug("User is male : {}", isMale);
        long yearBorn = 1971;
        LOG.debug("User was born at : {}", yearBorn);
        char dayBorn = 1;
        LOG.debug("User was born at day : {}", (int) dayBorn);
        short monthBorn = 1;
        LOG.debug("User was born at month : {}", monthBorn);
        byte dayOfWeekBorn = 1;
        LOG.debug("User was born at day of week : {}", dayOfWeekBorn);
    }
}