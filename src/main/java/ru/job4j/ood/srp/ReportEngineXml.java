package ru.job4j.ood.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.Element;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Predicate;


@XmlRootElement
public class ReportEngineXml implements Report {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @XmlTransient
    private final Store store;
    @XmlElement
    private List<Employee> list;
    @XmlTransient
    private JAXBContext context;
    @XmlTransient
    private Marshaller marshaller;

    public ReportEngineXml() {
        store = null;
    }

    public ReportEngineXml(Store store) {
        this.store = store;
        init();
    }

    private void init() {
        try {
            context = JAXBContext.newInstance(ReportEngineXml.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String result = "";
        Predicate<Employee> pre = i -> true;
        list = store.findBy(pre);
        StringWriter stringwriter = new StringWriter();
        try {
            marshaller.marshal(this, stringwriter);
            result = stringwriter.toString();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
