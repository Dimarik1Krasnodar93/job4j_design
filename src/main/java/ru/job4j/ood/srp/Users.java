package ru.job4j.ood.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Users {
    @XmlElement
    @Expose
    private List<User> users = new ArrayList<>();

    @XmlTransient
    @Expose
    private Marshaller marshaller;

    @XmlTransient
    private Gson gson;

    public Users() {
        init();
    }

    public Users(List<User> users) {
        init();
        this.users = users;
    }

    public Marshaller getMarshaller() {
        return marshaller;
    }

    public List<User> getUsers() {
        return users;
    }

    private void init() {
        initXml();
        initJson();
    }

    private void initXml() {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    private void initJson() {
        gson = new GsonBuilder().create();
    }

    public String getXml() {
        String result = "";
        try {
            StringWriter writer = new StringWriter();
            marshaller.marshal(this, writer);
            result = writer.toString();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public String getJson() {
        String result = "";
        result = gson.toJson(this);
        return result;
    }
}
