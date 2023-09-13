package org.dustyRoom.examples.office.models;

import org.dustyRoom.examples.office.Employee;

public class Manager implements Employee {
    @Override
    public void doJob() {
        System.out.println("I'm effective manager, I am good for nothing, hence I'm doing nothing");
    }

    public void managerJob() {
        System.out.println("this is a Manager department specific job");
        doJob();
    }
}
