package Lucky_Racer_Game;

public class AutomaticCar {

    private String modelName;
    private int year;
    private int speed;
    private int gear;
    private int odoMeter=0;
    private int mostUsedGearCount=0;
    private int mostUsedGear=0;
    private int gearZeroCount=0,gear1Count=0,gear2Count=0,gear3Count=0,gear4Count=0,gear5Count=0;
    // Method to initialize gears of car and count most used gear during the race.
    public void speedRanges(){

        if(speed==0) {
            gear = 0;
            gearZeroCount++;
        }
        else if (speed>=1 && speed<=100) {
            gear = 1;
            gear1Count++;
        }
        else if (speed>=101 && speed<=200) {
            gear = 2;
            gear2Count++;
        }
        else if (speed>=201 && speed<=300) {
            gear = 3;
            gear3Count++;
        }
        else if (speed>=301 && speed<=400) {
            gear = 4;
            gear4Count++;
        }
        else if (speed>=401 && speed<=500) {
            gear = 5;
            gear5Count++;
        }
    }
    //Constructor only to initialize name and make year
    public AutomaticCar(String modelName, int year) {
        this.modelName = modelName;
        this.year = year;
    }
    //Method to count total distance travelled by a car in the race
    public void odoMeter(int Distance){
        Distance=Distance+odoMeter;
        odoMeter=Distance;
    }
    //Method to print Scale
    public String scaleDistance(int km){
        for(int i=0; i<km; i++){
            System.out.print("*");
        }
        return "";
    }
    //Method to get Most Used Gear of winner car in race
    public void mostUsedGear(){
        if(gearZeroCount>mostUsedGearCount) {
            mostUsedGearCount = gearZeroCount;
            mostUsedGear=0;
        }
        if(gear1Count>mostUsedGearCount) {
            mostUsedGearCount = gear1Count;
            mostUsedGear=1;
        }
        if(gear2Count>mostUsedGearCount) {
            mostUsedGearCount = gear2Count;
            mostUsedGear=2;
        }
        if(gear3Count>mostUsedGearCount) {
            mostUsedGearCount = gear3Count;
            mostUsedGear=3;
        }
        if(gear4Count>mostUsedGearCount) {
            mostUsedGearCount = gear4Count;
            mostUsedGear=4;
        }
        if(gear5Count>mostUsedGearCount) {
            mostUsedGearCount = gear5Count;
            mostUsedGear=5;
        }
    }

    //Getter and Setters
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSpeed() {
        return speed;
    }
    //Setter method to validate Speed , Because speed can't be negative
    public void setSpeed(int speed) {
        if(speed<0){
            System.out.println("Speed can't be negative");
        }
        else {
            this.speed = speed;
        }
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getOdoMeter() {
        return odoMeter;
    }

    public void setOdoMeter(int odoMeter) {
        this.odoMeter = odoMeter;
    }

    public int getMostUsedGear() {
        return mostUsedGear;
    }

    public void setMostUsedGear(int mostUsedGear) {
        this.mostUsedGear = mostUsedGear;
    }

    public int getMostUsedGearCount() {
        return mostUsedGearCount;
    }

    public void setMostUsedGearCount(int mostUsedGearCount) {
        this.mostUsedGearCount = mostUsedGearCount;
    }
}
