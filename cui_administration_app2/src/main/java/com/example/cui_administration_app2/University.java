package com.example.cui_administration_app2;

import java.util.ArrayList;

public class University {

    private String universityName;
    private ArrayList<Campus> campuses = new ArrayList<>();

    public University() {
    }

    public University(String universityName, ArrayList<Campus> campuses) {
        this.universityName = universityName;
        this.campuses = campuses;
    }
    public void addCampus (Campus campus){
        campuses.add(campus);
    }
    public void removeCampus (Campus campus){
        campuses.remove(campus);
    }

    public Campus getCampus(String campusName){

        Campus campus=null;

        for (Campus campusFromList : campuses){
            if(campusName.equals(campusFromList.getCampusName())){
                campus = campusFromList;
            }
        }
        return campus;
    }


    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public ArrayList<Campus> getCampuses() {
        return campuses;
    }

    public void setCampuses(ArrayList<Campus> campuses) {
        this.campuses = campuses;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityName='" + universityName + '\'' +
                ", campuses=" + campuses +
                '}';
    }
}
