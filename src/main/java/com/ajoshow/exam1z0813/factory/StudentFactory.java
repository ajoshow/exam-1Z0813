package com.ajoshow.exam1z0813.factory;

import com.ajoshow.exam1z0813.domain.Student;

import java.util.Arrays;
import java.util.List;

public class StudentFactory {

    public static List<Student> sampleList() {
        return Arrays.asList(
                new Student("Alex", Student.Faculty.ENGINEER),
                new Student("Brian", Student.Faculty.ENGINEER),
                new Student("Dolores", Student.Faculty.BUSINESS),
                new Student("Carmen", Student.Faculty.BUSINESS)
        );
    }
}
