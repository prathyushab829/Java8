package org.example.bean;

import java.io.IOException;
import java.util.List;

public class Employee {

    String id;
    String name;
    List<String> certificates;

    public Employee(String id, String name, List<String> certificates) {
        this.id = id;
        this.name = name;
        this.certificates = certificates;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getCertificates() {
        return certificates;
    }

    public boolean hasValidId() {
        Employee e = new Employee(this.id,this.name,this.certificates);
        try {
            return Integer.valueOf(e.getId()) > 0;
        }catch (Exception ex){
            return false;
        }
    }
}
