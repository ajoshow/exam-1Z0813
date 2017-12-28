package com.ajoshow.exam1z0813;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class MethodReference2Main {
    public static class Student {
        private String name;
        private int marks;

        public Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        public Student(Student student) {
            this.name = student.name;
            this.marks = student.marks;
        }

        public void addMarks(int m){
            this.marks += m;
        }
        public void debug(){
            System.out.println(name+":"+marks);
        }

        public static void print(Student s){
            System.out.println(s);
        }

        public void check(Student s){
            System.out.println("check");
        }

    }

    public static void func(Student s){

    }

    public static void main(String[] args) {
        // https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
        List<Student> slist = Arrays.asList(
                new Student("S1", 40),
                new Student("S2", 35),
                new Student("S3", 30));

        // ContainingType::methodName
        slist.forEach(Student::debug);
        // ContainingClass::staticMethodName
        slist.forEach(MethodReference2Main::func);
        slist.forEach(Student::print);
        // containingObject::instanceMethodName
        slist.forEach(slist.get(0)::check);
        // ClassName::new
        slist.forEach(Student::new);

    }
}


