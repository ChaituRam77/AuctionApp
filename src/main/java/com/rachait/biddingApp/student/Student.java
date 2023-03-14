package com.rachait.biddingApp.student;

import java.time.LocalDate;

public class Student {

    private Long id;
    private String name;
    private String email;
    private LocalDate DOB;
    private Integer age;

    public Student() {
    }

    public Student(Long id, String name, String email, LocalDate DOB, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.DOB = DOB;
        this.age = age;
    }

    public Student(String name, String email, LocalDate DOB, Integer age) {
        this.name = name;
        this.email = email;
        this.DOB = DOB;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", DOB=" + DOB +
                ", age=" + age +
                '}';
    }
}
