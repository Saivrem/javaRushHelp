package org.dustyRoom.examples.polymorphism;

public class SecurityOfficer implements Employee {
    @Override
    public void doJob() {
        doHighSecurityJob();
    }

    private void doHighSecurityJob() {
        System.out.println("No one will know who I am and what I am doing");
    }
}
