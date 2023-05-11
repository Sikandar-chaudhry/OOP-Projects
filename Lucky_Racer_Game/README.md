![image](https://github.com/Sikandar-chaudhry/OOP-Projects/assets/107305245/7ef0bd38-f7bb-4d77-9084-c585038b3f8a)

This task covers multiple topics we have studied so far. I request to not only focus on completing the functional requirements but think well about where a specific code or functionality should be implemented and implemented it there. Also think over what fields should be allowed to be read by other objects and which ones should be kept private.

Create AutomaticCar class that shall contain private model, year, speed and gear attributes. Encapsulate complete state and expose the state for read/write (where it makes sense or required). As its an automatic car, so other shall not be able to update the gear attribute directly. The gear shall change automatically based on speed and other parameters (defined below). The speed range for different gears is as follows: (fromat: gear : speed-range)

0:0

1:1-100

2:101-200

3:201-300

4:301-400

5:401-500

The speed should not change when negative value is passed as argument to set method, in such cases, it should print an appropriate error message. If car's earlier speed was 50 KM/H and set method is called with argument 20, the car speed should become 20, not 70. Please note, same method should be used to increase and decrease the speed, depending on whether the earlier speed was low or high compared to new value passed in argument.

Here are some further points that you shall implement:

1. Make LuckyRacer class, in its main method, create 5 objects of AutomaticCar. These 5 cars shall participate in race, name these car objects: car1, car2 up to car 5. There shall be multiple rounds of the race, in each round you shall update speed based on a random value (detail given in next point), the car that got higher random number, in most number of rounds, on the average, shall win the race. Hint: one loop iteration can represent one round.


2. How to generate a random number? There is a class: Random in package java.util, create an object and call its method nextInt(x) ... where x is an int, it return a random number from 0 to x. Drive each car for 10 hours (10 rounds, each round of 1 hour), after each round, update the car speed to a random number, generated for each car separately, in range of 1 to 500 (inclusive). How you shall represent 1 hour in program? Run 10 iterations of for loop, assume each iteration represent 1 hour lap. The speed can go from 0 to any in-range speed directly and gear shall auto change to appropriate value as per speed.

3. Print the distance covered by each car after each hour. After 10 hours, the car with highest distance covered shall win. You shall print the car model that won the race e.g. "BMW i8 Won the race". As you know, distance (km) = time (hrs) X speed (km/hr). So, the maximum distance a car can travel in 10 hours, based on above rules is 5000 km, how? say each time maximum number was generated for the race (10 X 500). To calculate total distance traveled by each car, add another attribute, odoMeter in AutomaticCar and initialize it to 0. After each hour, add the total distance traveled by the car in that round in odoMeter field.

4. Print the status of race after each hour, i.e. which car is winning with the distance traveled by that car so far. The output may look like below. To fit on screen, lets set scale 1km = 100km, use dash '-' to represent scaled 1 km. Like this:

After 1 hour/s:

Car 1 -- : 200 km passed

Car 2 --- : 300 km passed

Car 3 -- : 250 km passed

Car 4 - : 180 km passed

Car 5 ---- : 400 km passed


(keep printing status in each loop iteration)
...
...

After 10 hour/s:

Car 1 ---------------------------------------------------------------------- : 2100 km passed

Car 2 -------------------------------------------------------------------------------- : 2700 km passed

Car 3 ------------------------------------------------------------ : 1800 km passed

Car 4 -------------------------------------------------- : 1500 km passed

Car 5 ---------------------------------------------------------------------- : 2100 km passed


Car 2, BMW i8 Won the Race.

Above dashes are example, use a scale to represent distance correctly in single line. You shall also print the gear number the winner car used mostly during race, based on gear average and rounding it at zero decimal places.
