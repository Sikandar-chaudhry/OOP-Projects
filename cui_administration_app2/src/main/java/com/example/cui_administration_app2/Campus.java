package com.example.cui_administration_app2;

import java.util.ArrayList;

public class Campus {

    private String campusName;
    private String campusAddress;
    private Director director;
    private ArrayList<Department> departments = new ArrayList<>();

    public Campus() {
    }

    public Campus(String campusName, String campusAddress, Director director, ArrayList<Department> departments) {
        this.campusName = campusName;
        this.campusAddress = campusAddress;
        this.director = director;
        this.departments = departments;
    }
    public void addDepartment(Department department){
        departments.add(department);
    }
    public void removeDepartment(Department department){
        departments.remove(department);
    }
    public Department getDepartment(String departmentName){
        Department department=null;

        for (Department departmentFromList : departments){
            if(departmentName.equals(departmentFromList.getDepartmentName())){
                department = departmentFromList;
            }
        }
        return department;
    }
    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getCampusAddress() {
        return campusAddress;
    }

    public void setCampusAddress(String campusAddress) {
        this.campusAddress = campusAddress;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Campus{" +
                "campusName='" + campusName + '\'' +
                ", campusAddress='" + campusAddress + '\'' +
                ", director=" + director +
                ", departments=" + departments +
                '}';
    }
}
