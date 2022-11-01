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



public class ReportEngineXml implements Report {

    private final Store store;

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
            JAXBContext context = JAXBContext.newInstance(ReportEngineXml.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String result = "";
        StringWriter stringwriter = new StringWriter();
        try {
            List<Employee> employees = store.findBy(filter);
            marshaller.marshal(new Employees(employees), stringwriter);
            result = stringwriter.toString();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return result;
    }


    @XmlRootElement(name = "employees")
    private static class Employees {

        private List<Employee> employees;

        public Employees(List<Employee> employees) {
            this.employees = employees;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }
    }
}
