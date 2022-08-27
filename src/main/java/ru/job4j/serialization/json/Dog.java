package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONPropertyIgnore;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

@XmlRootElement (name = "dog")
public class Dog {

    public boolean getMale() {
        return isMale;
    }

    public String getName() {
        return name;
    }

    public int getYearBorn() {
        return yearBorn;
    }

    @XmlAttribute
    private boolean isMale;

    @XmlAttribute
    private String name;

    @XmlAttribute
    private int yearBorn;

    @JSONPropertyIgnore
    public Dog[] getPets() {
        return pets;
    }

    @XmlElement
    private Dog[] pets;

    public void setPets(Dog[] pets) {
        this.pets = pets;
    }

    public Dog() {

    }

    public Dog(boolean isMale, String name, int yearBorn, Dog[] pets) {
        this.isMale = isMale;
        this.name = name;
        this.yearBorn = yearBorn;
        this.pets = pets;
    }

    public Dog(boolean isMale, String name, int yearBorn) {
        this.isMale = isMale;
        this.name = name;
        this.yearBorn = yearBorn;
    }

    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder("IsMale = ");
        strBuild.append(isMale);
        strBuild.append("\nname = ");
        strBuild.append(name);
        strBuild.append("\nyearBorn = ");
        strBuild.append(yearBorn);
        strBuild.append("\nPets = ");
        for (Dog pet : pets) {
            strBuild.append(pet.name);
            strBuild.append(";");
        }
        return strBuild.toString();
    }

    public static void main(String[] args) throws JAXBException {
        Dog[] mainPets = new Dog[2];
        mainPets[0] = new Dog(false, "Berta", 2010);
        mainPets[1] = new Dog(true, "Rex", 2010);
        Dog dana = new Dog(false, "Dana", 2004, mainPets);
        final Gson gson = new GsonBuilder().create();
        String stringGson = gson.toJson(dana);
        Dog fromGson = gson.fromJson(stringGson, Dog.class);
        System.out.println(fromGson);
        JAXBContext context =  JAXBContext.newInstance(Dog.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(dana, writer);
            xml = writer.getBuffer().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Dog doxXmlRes = (Dog) unmarshaller.unmarshal(reader);
            System.out.println("XML: " + doxXmlRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
