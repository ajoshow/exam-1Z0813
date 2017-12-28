package com.ajoshow.exam1z0813.factory;

import com.ajoshow.exam1z0813.domain.Employee;
import com.ajoshow.exam1z0813.domain.Student;

import java.util.Arrays;
import java.util.List;

public class EmployeeFactory {

    public static List<Employee> sampleList() {
        return Arrays.asList(
                new Employee("Alex", 20, 100.0, 9999999),
                new Employee("Brian", 18, 88, 8888888),
                new Employee("Dolores", 36, 132.5, 3333333),
                new Employee("Carmen", 40, 200.0, 4444444),
                new Employee("Ethan", 66, 100.0, 2222222),
                new Employee("Golden", 55, 500.0, 1111111),
                new Employee("Frank", 50, 65.6, 5555555)
        );
    }
}
