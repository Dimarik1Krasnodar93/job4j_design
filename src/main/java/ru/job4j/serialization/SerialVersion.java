package ru.job4j.serialization;

import ru.job4j.serialization.java.Contact;

import java.nio.charset.StandardCharsets;

public class SerialVersion {
    public static long computeSerialVersion(Contact contact) {
        long serialVersionUID = 0;
        byte[] bytes = contact.getPhone().getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < bytes.length; i++) {
            serialVersionUID += bytes[i] * Math.pow(10, bytes.length + 1 - i);
        }
        serialVersionUID = serialVersionUID + contact.getZipCode();
        return serialVersionUID;
    }
}
