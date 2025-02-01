package com.Entity;

import java.util.Comparator;

public class Employee {
    String name;
    double salary;
    int age;
    String department;

    // Constructor
    public Employee(String name, double salary, int age, String department) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.department = department;
    }

    // toString for printing
    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + ", age=" + age + ", department='" + department + "'}";
    }

    // Comparators
    public static final Comparator<Employee> BY_NAME = Comparator.comparing(emp -> emp.name);
    public static final Comparator<Employee> BY_SALARY = Comparator.comparingDouble(emp -> emp.salary);
    public static final Comparator<Employee> BY_AGE = Comparator.comparingInt(emp -> emp.age);
    public static final Comparator<Employee> BY_DEPARTMENT = Comparator.comparing(emp -> emp.department);

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }
}
