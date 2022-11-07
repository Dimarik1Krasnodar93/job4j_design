package ru.job4j.ood.srp.design.report;

import ru.job4j.ood.srp.Store;
import ru.job4j.ood.srp.design.model.Employee;
import ru.job4j.ood.srp.design.report.Report;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;



public class ReportEngineXml implements Report {

    private final Store store;

    private Marshaller marshaller;

    public ReportEngineXml(Store store) {
        this.store = store;
        init();
    }

    private void init() {
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String result = "";
        try (StringWriter stringwriter = new StringWriter()) {
            List<Employee> employees = store.findBy(filter);
            marshaller.marshal(new Employees(employees), stringwriter);
            result = stringwriter.toString();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @XmlRootElement(name = "employees")
    @XmlAccessorType(XmlAccessType.FIELD)
    private static class Employees {

        private List<Employee> employees;

        public Employees(List<Employee> employees) {
            this.employees = employees;
        }

        public Employees() {
        }
            public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }
    }
}
