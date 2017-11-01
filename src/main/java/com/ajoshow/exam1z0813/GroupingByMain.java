package com.ajoshow.exam1z0813;

import com.ajoshow.exam1z0813.domain.Student;
import com.ajoshow.exam1z0813.factory.StudentFactory;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingByMain {

    public static void main(String[] args) {
        Map<Student.Faculty, List<Student>> map = StudentFactory.sampleList().stream()
                .collect(Collectors.groupingBy(Student::getFaculty));
        System.out.println(map);

        Map<Student.Faculty, List<String>> map2 = StudentFactory.sampleList().stream()
                .collect(Collectors.groupingBy(Student::getFaculty, Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(map2);

        Map<Student.Faculty, Set<String>> map3 = StudentFactory.sampleList().stream()
                .collect(Collectors.groupingBy(Student::getFaculty, TreeMap::new, Collectors.mapping(Student::getName, Collectors.toSet())));
        System.out.println(map3);
    }


}
