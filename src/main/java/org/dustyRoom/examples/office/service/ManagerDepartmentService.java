package org.dustyRoom.examples.office.service;

import org.dustyRoom.examples.office.DepartmentService;
import org.dustyRoom.examples.office.Employee;
import org.dustyRoom.examples.office.models.Manager;

public class ManagerDepartmentService implements DepartmentService<Manager> {

    @Override
    public boolean isApplicable(Employee employee) {
        return employee instanceof Manager;
    }

    @Override
    public void process(Manager employee) {
        employee.managerJob();
    }
}
