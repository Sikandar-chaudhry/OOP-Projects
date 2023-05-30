package com.example.project;

import java.util.ArrayList;

public class Department {

    private HOD hod;
    private String departmentName;
    private ArrayList<Lab> labs = new ArrayList<>();

    public Department() {
    }

    public Department(ArrayList<Lab> labs) {
        this.labs = labs;
    }

    public Department(HOD hod, String departmentName, ArrayList<Lab> labs) {
        this.hod = hod;
        this.departmentName = departmentName;
        this.labs = labs;
    }

    public Department(HOD hod, ArrayList<Lab> labs) {
        this.hod = hod;
        this.labs = labs;
    }

    public void addLab (Lab lab){
        labs.add(lab);
    }
    public void removeLab(Lab lab){
        labs.remove(lab);
    }
    public Lab getLab(String labName){

        Lab lab=null;

        for (Lab labFromList : labs){
            if(labName.equals(labFromList.getLabName())){
                lab = labFromList;
            }
        }
        return lab;
    }
    public HOD getHod() {
        return hod;
    }

    public void setHod(HOD hod) {
        this.hod = hod;
    }

    public ArrayList<Lab> getLabs() {
        return labs;
    }

    public void setLabs(ArrayList<Lab> labs) {
        this.labs = labs;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    @Override
    public String toString() {
        return "Department{" +
                "hod=" + hod +
                ", departmentName='" + departmentName + '\'' +
                ", labs=" + labs +
                '}';
    }
}
