package org.dustyRoom.examples.office.models;

import org.dustyRoom.examples.office.Employee;

public class SecurityOfficer implements Employee {
    @Override
    public void doJob() {
        System.out.println("No one will know who I am and what I am doing");
    }

    public void doHighSecurityJob() {
        System.out.println("This is a SecurityOfficer department specific job");
        doJob();
    }
}
