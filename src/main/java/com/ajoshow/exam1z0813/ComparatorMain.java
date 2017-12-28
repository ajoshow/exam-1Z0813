package com.ajoshow.exam1z0813;

import com.ajoshow.exam1z0813.domain.Employee;
import com.ajoshow.exam1z0813.factory.EmployeeFactory;

import java.util.*;

public class ComparatorMain {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,1,7,6,9,0);

        numbers.stream().sorted(Comparator.comparing(Integer::intValue)).forEach(System.out::print);
        System.out.println();
        numbers.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).forEach(System.out::print);
        System.out.println();

        List<Employee> employees = EmployeeFactory.sampleList();

        employees.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getAge)).forEach(System.out::println);

    }
}
