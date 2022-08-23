package ru.job4j.io;

import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        String city = "Moscow";
        LOG.debug("User's city : {}", city);
        String country = "Russia";
        LOG.debug("User's city : {}", country);
        String education = "engineer";
        LOG.debug("User's education : {}", education);
        String educationCountry = "Russia";
        LOG.debug("User's education country : {}", educationCountry);
    }
}