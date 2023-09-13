package org.dustyRoom.examples.office.service;

import org.dustyRoom.examples.office.DepartmentService;
import org.dustyRoom.examples.office.Employee;
import org.dustyRoom.examples.office.models.SecurityOfficer;

public class SecurityOfficerDepartmentService implements DepartmentService<SecurityOfficer> {

    @Override
    public boolean isApplicable(Employee employee) {
        return employee instanceof SecurityOfficer;
    }

    @Override
    public void process(SecurityOfficer employee) {
        employee.doHighSecurityJob();
    }
}
