package com.example.project;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Employee implements Serializable {

    private String username;
    private String password;
    private String name;
    private String grade;

    private final Set<String> assignedUsernames = new HashSet<>();
    public Employee() {
    }

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Employee(String username, String password, String name, String grade) {
        if (assignedUsernames.contains(username)){
            throw new IllegalArgumentException("Username already taken : "+username);
        }
        this.username = username;
        this.password = password;
        this.name = name;
        this.grade = grade;
        assignedUsernames.add(username);
    }

    public Employee(String name, String grade,String s) {
        this.name = name;
        this.grade = grade;
        s = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
