package com.example.project;

import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
        Lab lab =new Lab();
        Department department = new Department();
        Scanner scan = new Scanner(System.in);
        String name;
        String grade;
        String systemId;
        String systemName;
        String systemSpeed;
        String ramSize;
        String hardDiskSize;
        String lcdMakeModel;
        String labName;
        ArrayList<Lab> labArrayList = new ArrayList<>();



        Boolean control = true;
        while (control){
            System.out.println("Enter name : ");
            name = scan.nextLine();
            System.out.println("Enter grade : ");
            grade = scan.nextLine();
            System.out.println("Enter System Id : ");
            systemId = scan.nextLine();
            System.out.println("Enter system Name : ");
            systemName=scan.nextLine();
            System.out.println("Enter system Speed : ");
            systemSpeed=scan.nextLine();
            System.out.println("Enter Ram Size : ");
            ramSize=scan.nextLine();
            System.out.println("Enter HardDisk Size : ");
            hardDiskSize=scan.nextLine();
            System.out.println("Enter LCD Make Model : ");
            lcdMakeModel=scan.nextLine();
            System.out.println("Enter lab Name : ");
            labName =scan.nextLine();
            Employee employee = new Employee(name,grade,null);
            LabStaff labStaff = new LabStaff(name,grade);
            Computer computer = new Computer(systemId,systemName,systemSpeed,ramSize,hardDiskSize,lcdMakeModel);
            lab.addComputer(computer);

            boolean projector = true;
            Lab lab1 = new Lab(labStaff, projector,labName,lab.getComputers());
            department.addLab(lab1);
            labArrayList.add(lab1);
            String quit;
            System.out.println("Enter q to quit or anyother key to continue : ");
            quit=scan.nextLine();
            if (quit.equalsIgnoreCase("q")){
                control = false;
            }
        }
//        ArrayList<Computer> computers = lab.getComputers();
//        for (Computer c : computers){
//            System.out.println(c);
//        }
//        for (Lab l : labArrayList){
//            System.out.println(l);
//        }
       // System.out.println(department.getLab("1"));

    }
}
