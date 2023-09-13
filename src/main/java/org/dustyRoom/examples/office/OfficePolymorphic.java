package org.dustyRoom.examples.office;

public class OfficePolymorphic extends Office {

    public static void main(String[] args) {
        Office office = new OfficePolymorphic();
        office.work();
    }

    /**
     * Here are all Employee have same method to work, so behaviour
     * does not depend on Employee subtype
     */
    @Override
    protected void work() {
        employeeList.forEach(Employee::doJob);
    }
}

