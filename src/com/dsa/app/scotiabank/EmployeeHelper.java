package com.dsa.app.scotiabank;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHelper {
    public static void main(String[] args) throws CloneNotSupportedException {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Chandan Shukla");

        List<Department> departments = new ArrayList<>();
        Department department1 = new Department();
        department1.setDepartmentId(1);
        department1.setDepartmentName("HR");

        Department department2 = new Department();
        department1.setDepartmentId(2);
        department1.setDepartmentName("Accounts");

        Department department3 = new Department();
        department1.setDepartmentId(3);
        department1.setDepartmentName("Contact");

        Department department4 = new Department();
        department1.setDepartmentId(3);
        department1.setDepartmentName("Contact 2");

        departments.add(department1);
        departments.add(department2);
        departments.add(department3);
        employee.setDepartments(departments);

        Employee employee2 = (Employee) employee.clone();
        employee.setName("Udit");
        employee.setDepartments(null);
        //employee.getDepartments().add(department4);
        if (employee2.getDepartments() == null) {
            System.out.println("Departments are null for employee 2.");
        } else {
            System.out.println("Not null.");
        }
    }
}
