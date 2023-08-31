package org.dustyRoom.examples.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private final List<Employee> employeeList = new ArrayList<>();

    private void initEmployees() {
        employeeList.add(new Manager());
        employeeList.add(new Plumber());
        employeeList.add(new SecurityOfficer());
    }

    private void work() {
        employeeList.forEach(Employee::doJob);
    }

    public static void main(String[] args) {
        Office office = new Office();
        office.initEmployees();
        office.work();
    }
}
