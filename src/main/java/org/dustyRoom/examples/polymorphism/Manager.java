package org.dustyRoom.examples.polymorphism;

public class Manager implements Employee {
    @Override
    public void doJob() {
        System.out.println("I'm effective manager, I am good for nothing, hence I'm doing nothing");
    }
}
