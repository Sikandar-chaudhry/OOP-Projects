package com.example.cui_administration_app2;

import java.util.ArrayList;

public class Lab {

    private LabStaff incharge;
    private boolean hasProjector;
    private String labName;
    private ArrayList<Computer> computers= new ArrayList<>();
    public Lab() {
    }

    public Lab(ArrayList<Computer> computers) {
        this.computers = computers;
    }

    public Lab(LabStaff incharge, boolean hasProjector, String labName, ArrayList<Computer> computers) {
        this.incharge = incharge;
        this.hasProjector = hasProjector;
        this.labName = labName;
        this.computers = computers;
    }

    public Lab(LabStaff incharge, boolean hasProjector, ArrayList<Computer> computers) {
        this.incharge = incharge;
        this.hasProjector = hasProjector;
        this.computers = computers;
    }

    public void addComputer(Computer computer){
        computers.add(computer);
    }
    public void removeComputer(Computer computer){
        computers.remove(computer);
    }
    public Computer getComputer(String computerId){

        Computer computer=null;

        for (Computer computerFromList : computers){
            if(computerId.equals(computerFromList.getSystemId())){
                computer = computerFromList;
            }
        }
        return computer;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public LabStaff getIncharge() {
        return incharge;
    }

    public void setIncharge(LabStaff incharge) {
        this.incharge = incharge;
    }

    public boolean isHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    public ArrayList<Computer> getComputers() {
        return computers;
    }

    public void setComputers(ArrayList<Computer> computers) {
        this.computers = computers;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "incharge=" + incharge +
                ", hasProjector=" + hasProjector +
                ", labName='" + labName + '\'' +
                ", computers=" + computers +
                '}';
    }
}
