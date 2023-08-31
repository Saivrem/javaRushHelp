package org.dustyRoom.examples.polymorphism;

public class Plumber implements Employee {
    @Override
    public void doJob() {
        System.out.println("I'm Plumber, I am fixing pipes");
    }
}
