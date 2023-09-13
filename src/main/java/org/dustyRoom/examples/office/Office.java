package org.dustyRoom.examples.office;

import org.dustyRoom.examples.office.models.Manager;
import org.dustyRoom.examples.office.models.Plumber;
import org.dustyRoom.examples.office.models.SecurityOfficer;

import java.util.ArrayList;
import java.util.List;

public abstract class Office {
    protected final List<Employee> employeeList = new ArrayList<>();

    public Office() {
        initEmployees();
    }

    private void initEmployees() {
        employeeList.add(new Manager());
        employeeList.add(new Plumber());
        employeeList.add(new SecurityOfficer());
    }

    protected abstract void work();
}
