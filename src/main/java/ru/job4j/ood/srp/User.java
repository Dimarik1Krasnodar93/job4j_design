package ru.job4j.ood.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    @XmlAttribute
    private final String name;
    @XmlAttribute
    private final String lastName;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public User() {
        name = "";
        lastName = "";
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
