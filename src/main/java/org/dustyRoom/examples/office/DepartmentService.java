package org.dustyRoom.examples.office;

public interface DepartmentService<T extends Employee> {

    boolean isApplicable(Employee employee);

    void process(T employee);
}
