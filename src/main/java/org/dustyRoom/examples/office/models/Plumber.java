package org.dustyRoom.examples.office.models;

import org.dustyRoom.examples.office.Employee;

public class Plumber implements Employee {
    @Override
    public void doJob() {
        System.out.println("I'm Plumber, I am fixing pipes");
    }

    public void plumberJob() {
        System.out.println("this is a Plumber department specific job");
        doJob();
    }
}
