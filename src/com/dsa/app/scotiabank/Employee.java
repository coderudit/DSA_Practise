package com.dsa.app.scotiabank;

import java.util.List;

public class Employee implements Cloneable {
    private int id;
    private String name;
    private List<Department> departments;;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
