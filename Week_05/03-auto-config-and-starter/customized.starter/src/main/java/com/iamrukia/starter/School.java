package com.iamrukia.starter;

public class School implements ISchool {

    Klass klass;

    public School(Klass klass) {
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public void ding() {

        System.out.println("Class1 have " + klass.getStudents().size() + " students and one is " + klass.getStudents().get(0).toString());

    }

}

