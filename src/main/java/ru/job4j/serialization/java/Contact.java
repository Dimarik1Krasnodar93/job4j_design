package ru.job4j.serialization.java;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Stream;

public class Contact implements Serializable {
    private static long serialVersionUID;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
        byte[] bytes = phone.getBytes();
        serialVersionUID = 0;
        for (int i = 0; i < bytes.length; i++) {
            serialVersionUID += bytes[i] * Math.pow(10, bytes.length + 1 - i);
        }
        serialVersionUID = serialVersionUID + zipCode;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "zipCode=" + zipCode
                + ", phone='" + phone + '\''
                + '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(123456, "+7 (111) 111-11-11");
        File tempFile = Files.createTempFile(null, null).toFile();
        try (FileOutputStream fos = new FileOutputStream(tempFile);
             ObjectOutputStream oos =
                     new ObjectOutputStream(fos)) {
            oos.writeObject(contact);
        }
        try (FileInputStream fis = new FileInputStream(tempFile);
             ObjectInputStream ois =
                     new ObjectInputStream(fis)) {
            final Contact contactFromFile = (Contact) ois.readObject();
            System.out.println(contactFromFile);
            if (contact.getSerialVersionUID() != contactFromFile.getSerialVersionUID()) {
                throw new InvalidClassException("Incorrect serialization");
            }
        }

    }
}
