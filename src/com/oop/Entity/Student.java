package com.oop.Entity;

public class Student extends Person {

  private static int fee = 1000;
  int rollNo;
  String course;

  public Student(String name, int age, int rollNo, String course) {
    super(name, age);
    this.rollNo = rollNo;
    this.course = course;
  }

  public int getRollNo() {
    return rollNo;
  }

  public void setRollNo(int rollNo) {
    this.rollNo = rollNo;
  }

  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  @Override
  public void introduce() {
    super.introduce();
    System.out.println("I am studying " + course + " and my roll number is " + rollNo + ".");
  }

  public void study() {
    System.out.println("I am studying.");
  }
}
