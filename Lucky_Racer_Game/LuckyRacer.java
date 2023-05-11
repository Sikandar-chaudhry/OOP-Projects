package Lucky_Racer_Game;

import java.util.Random;
import java.util.Scanner;

public class LuckyRacer {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        Random random=new Random();

        String name;
        int year;

        System.out.println("Enter name of first participant Car : ");
        name=input.nextLine();
        System.out.println("Enter the make year of the car : ");
        year= input.nextInt();
        input.nextLine();
        AutomaticCar car1=new AutomaticCar(name,year);

        System.out.println("Enter name of second participant Car : ");
        name=input.nextLine();
        System.out.println("Enter the make year of the car : ");
        year= input.nextInt();
        input.nextLine();
        AutomaticCar car2=new AutomaticCar(name,year);

        System.out.println("Enter name of third participant Car : ");
        name=input.nextLine();
        System.out.println("Enter the make year of the car : ");
        year= input.nextInt();
        input.nextLine();
        AutomaticCar car3=new AutomaticCar(name,year);

        System.out.println("Enter name of forth participant Car : ");
        name=input.nextLine();
        System.out.println("Enter the make year of the car : ");
        year= input.nextInt();
        input.nextLine();
        AutomaticCar car4=new AutomaticCar(name,year);

        System.out.println("Enter name of fifth participant Car : ");
        name=input.nextLine();
        System.out.println("Enter the make year of the car : ");
        year= input.nextInt();
        input.nextLine();
        AutomaticCar car5=new AutomaticCar(name,year);

        int randomSpeed;
        int distance;

        for (int i=1; i<=10; i++){
            randomSpeed= random.nextInt(1,500);
            car1.setSpeed(randomSpeed);
            car1.speedRanges();
            //Distance = time*speed  In this case, we deal with speed per hour , so time = 1 hour , Distance =1*Speed;
            distance=1*randomSpeed;
            car1.odoMeter(distance);

            randomSpeed= random.nextInt(1,500);
            car2.setSpeed(randomSpeed);
            car2.speedRanges();
            //Distance = time*speed  In this case, we deal with speed per hour , so time = 1 hour , Distance =1*Speed;
            distance=1*randomSpeed;
            car2.odoMeter(distance);

            randomSpeed= random.nextInt(1,500);
            car3.setSpeed(randomSpeed);
            car3.speedRanges();
            //Distance = time*speed  In this case, we deal with speed per hour , so time = 1 hour , Distance =1*Speed;
            distance=1*randomSpeed;
            car3.odoMeter(distance);

            randomSpeed= random.nextInt(1,500);
            car4.setSpeed(randomSpeed);
            car4.speedRanges();
            //Distance = time*speed  In this case, we deal with speed per hour , so time = 1 hour , Distance =1*Speed;
            distance=1*randomSpeed;
            car4.odoMeter(distance);

            randomSpeed= random.nextInt(1,500);
            car5.setSpeed(randomSpeed);
            car5.speedRanges();
            //Distance = time*speed  In this case, we deal with speed per hour , so time = 1 hour , Distance =1*Speed;
            distance=1*randomSpeed;
            car5.odoMeter(distance);

            System.out.println("After " +i+" hours/s : " );


            System.out.print("Car 1 ");
            // Each * = 100km
            car1.scaleDistance(car1.getOdoMeter()/100);
            System.out.println(" : "+car1.getOdoMeter()+" Passed ");

            System.out.print("Car 2 ");
            // Each * = 100km
            car2.scaleDistance(car2.getOdoMeter()/100);
            System.out.println(" : "+car2.getOdoMeter()+" Passed ");

            System.out.print("Car 3 ");
            // Each * = 100km
            car3.scaleDistance(car3.getOdoMeter()/100);
            System.out.println(" : "+car3.getOdoMeter()+" Passed ");

            System.out.print("Car 4 ");
            // Each * = 100km
            car4.scaleDistance(car4.getOdoMeter()/100);
            System.out.println(" : "+car4.getOdoMeter()+" Passed ");

            System.out.print("Car 5 ");
            // Each * = 100km
            car5.scaleDistance(car5.getOdoMeter()/100);
            System.out.println(" : "+car5.getOdoMeter()+" Passed ");

        }
        // Winner Car Selection
        AutomaticCar winner=null;
        int highestMaxDistance=0;

        // Finding car with most distance covered in All rounds
        if(car1.getOdoMeter()>highestMaxDistance){
            highestMaxDistance=car1.getOdoMeter();
            winner=car1;
        }
        if(car2.getOdoMeter()>highestMaxDistance){
            highestMaxDistance=car2.getOdoMeter();
            winner=car2;
        }
        if(car3.getOdoMeter()>highestMaxDistance){
            highestMaxDistance=car3.getOdoMeter();
            winner=car3;
        }
        if(car4.getOdoMeter()>highestMaxDistance){
            highestMaxDistance=car4.getOdoMeter();
            winner=car4;
        }
        if(car5.getOdoMeter()>highestMaxDistance){
            highestMaxDistance=car5.getOdoMeter();
            winner=car5;
        }

        System.out.println(winner.getModelName()+" Won the Race ");
        winner.mostUsedGear();
        System.out.println("The gear number the winner car used mostly during race = "+winner.getMostUsedGear());

    }

}
