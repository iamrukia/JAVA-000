package com.iamrukia.starter;

import java.util.ArrayList;
import java.util.List;

public class Klass {

    List<Student> students;

    public Klass(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void dong() {
        this.getStudents().forEach(Student::toString);
    }

}
