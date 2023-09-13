package org.dustyRoom.examples.office;

import org.dustyRoom.examples.office.service.ManagerDepartmentService;
import org.dustyRoom.examples.office.service.PlumberDepartmentService;
import org.dustyRoom.examples.office.service.SecurityOfficerDepartmentService;

import java.util.List;

@SuppressWarnings({"unchecked", "rawtypes"})
public class OfficeGenerified extends Office {

    //DI Emulation
    private final List<DepartmentService> departments =
            List.of(
                    new ManagerDepartmentService(),
                    new PlumberDepartmentService(),
                    new SecurityOfficerDepartmentService()
            );

    public static void main(String[] args) {
        Office office = new OfficeGenerified();
        office.work();
    }


    /**
     * In this example Employees are actually different and for some reason
     * should be processed differently according to their subtype
     * For this purpose we have a list of services that is being picked for each
     * particular employee and process it
     */
    @Override
    protected void work() {
        for (Employee employee : employeeList) {
            departments.stream()
                    .filter(s -> s.isApplicable(employee))
                    .findFirst()
                    .ifPresent(service -> service.process(employee));
        }
    }
}
