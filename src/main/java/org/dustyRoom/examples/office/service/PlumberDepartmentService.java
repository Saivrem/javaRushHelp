package org.dustyRoom.examples.office.service;

import org.dustyRoom.examples.office.DepartmentService;
import org.dustyRoom.examples.office.Employee;
import org.dustyRoom.examples.office.models.Plumber;

public class PlumberDepartmentService implements DepartmentService<Plumber> {
    @Override
    public boolean isApplicable(Employee employee) {
        return employee instanceof Plumber;
    }

    @Override
    public void process(Plumber employee) {
        employee.plumberJob();
    }
}
