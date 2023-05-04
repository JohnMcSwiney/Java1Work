

/**
 * CopyOfCopyOfProgAssignIII -This is our submission for the 3rd programming project.
 * ((there's an easter egg in it))
 * @author (Johnny McSwiney, Jack Eyre) 
 * @version (V1.03 - Dec 12 2021)
 */
// Standard import for the Scanner class
import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class ProgammingAssignmentIII {
    // Holds cars for the program
    public static ArrayList <Car> carsList = new ArrayList<Car>();
   
    // Used to close the program when needed
    public static boolean running = true;

    // Used to increment rentals for the session
    public static int numOfRent = 0;
    
    // Used to calculate estimated revenue for this session
    public static int estRev = 0;
    
    public String spacer = "*  *  *  *  *"; 
    
    //public static int count = 0;
    public static void main (String [] args) throws Exception{
        Scanner input = new Scanner(System.in);
        
        int rN = randomNum();
        if (rN == 3){ System.out.println("*-|-* Welcome to Mo's Classic Car Rentals *-|-*"); } 
        else { System.out.println("* * * Welcome to Mo's Classic Car Rentals * * *"); } 
        
        System.out.println();
        
        Scanner bruh = new Scanner(System.in);
        System.out.print(" Enter car data filename: ");
        String TheFile = input.nextLine();
        //E:\temp\classiccars.csv
        System.out.println();
        System.out.println();
        
        String TheFilee =( "C:/temp/classiccars.csv" );
        String fLocation = (TheFile); 
        bruh.close();
        updateList(TheFile);
        
        if ( TheFile == null){
            System.out.println ("File does not exist");
        }
        
        runMenu(rN);
    }

    
    /** Used to Run the main menu. 
     *  Called at the end of a selection
     *  Uses chance for easter egg
     */
    public static void runMenu(int chance){
         boolean isRunning = true;
         int total = 0;
         
            PrintList(carsList);
        
            System.out.println();
            System.out.println("Options");
            System.out.println(" A. Rent a car");
            System.out.println(" B. Return a car");
            System.out.println(" C. Flag car for servicing");
            System.out.println(" D. Clear car from servicing");
            System.out.println(" E. To exit program");
            if(chance == 3){
                System.out.println(" F. Secret Option");
            }
            System.out.println();
    
            Scanner in = new Scanner (System.in);
            
        System.out.print("Enter your option (by letter): ");
            char h = in.next().charAt(0);
        System.out.println();
            
        in.close();
        
            char h2 = Character.toUpperCase(h);
        
            switch(h2){ 
                case 'A':
                   System.out.println("Rent a car. Enter car selection (by number): ");
                    Scanner input = new Scanner(System.in);
                    int selection2 = input.nextInt();
                    input.close();
                
                    RentCar(selection2, carsList);  
                    runMenu(chance);
                    
                    break;
                    
                case 'B':
                    System.out.println("Rent a car. Enter car selection (by number): ");
                    input = new Scanner(System.in);
                    selection2 = input.nextInt();
                    input.close();
                
                    returnCar(selection2, carsList);  
                    runMenu(chance);
                    break;
                
                case 'C':
                    System.out.println("Rent a car. Enter car selection (by number): ");
                    input = new Scanner(System.in);
                    selection2 = input.nextInt();
                    input.close();
                
                    flagService(selection2, carsList);   
                    
                    runMenu(chance);
                    break;
                
                case 'D':
                    System.out.println("Rent a car. Enter car selection (by number): ");
                    input = new Scanner(System.in);
                    selection2 = input.nextInt();
                    input.close();
                
                    clearService(selection2, carsList);   
                    
                    runMenu(chance);
                    break;
                
                case 'E':
                    System.out.println("Total rental rate revenuse from this session: " + getIncrement());
                    System.out.println("Number of rentals initianted in this session: $" + getTotal());
                    System.out.println();
                    System.out.println("Goodbye :)");
                    
                    closeProgram();
                break;
                
                case 'F':
                    if(chance == 3){
                        String f = " ";
                        System.out.println("Special secret lolol");
                        System.out.println();
                        System.out.println(".-'--`-._");
                        System.out.println("'-O---O--'");
                        System.out.println();
                        System.out.println("cool little ascii car!");
                        System.out.println("Art by: Max Strandberg");
                        System.out.println();
                    }
                    runMenu(chance);
                 break;
                    
                default:
                    System.out.println();
               //}
            }   
    }
    
    
    /** Make list
     *  Requires Car list
     *  Send car list location when constructing 
     */
    public static void updateList(String theFile) throws Exception{
        
        File file = new File(theFile);
        
        Scanner in = new Scanner(file);
        
        in.useDelimiter("[\\n]");
        // Holds Car info to put into car array
        ArrayList <String> carz = new ArrayList<String>();
        
        for( int i = 0; i < 5;i++){
            carz.add(in.next());
        }
        
        
        for (int i = 0; i < carz.size(); i++) {
            
            //Search carz to get the info from it
            Scanner carbot = new Scanner(carz.get(i));
            carbot.useDelimiter("[,]");
            
            //System.out.println(carz.get(i));
            // Using .next to put the info into strings
            String year0 = carbot.next();// int
            String make = carbot.next();// string
            String model = carbot.next();// string
            String rate0 = carbot.next();// int
            String needS0 = carbot.next();// bool
            String isRent0 = carbot.next();// bool
            String rentN = carbot.next();// string
            String rentP = carbot.next();// string
            
            // Converting Strings to their required data type
            int year = Integer.valueOf(year0);
            int rate = Integer.valueOf(rate0);
            boolean needS = Boolean.parseBoolean(needS0);
            boolean isRent = Boolean.parseBoolean(isRent0);
            
            Car newCar = new Car(make, model ,year ,rate ,needS, isRent, rentN, rentP);
            carsList.add(newCar);
            
            //System.out.println("This is car # " + (i+1));
            //System.out.println(carsList.size());
            
        }
    }
    
    /** Print list,
     *  Prints out menu items, then
     *  Takes in an arraylist with the cars and print it out,
     */ 
    public static void PrintList(ArrayList <Car> list ){ 
        String spacer = "*  *  *  *  *"; 
        
        System.out.printf(" %32s \n",spacer);
        System.out.println();
        System.out.println(" - Cars - ");
        
        for( int i = 0; i < 5; i++){
            System.out.println(" " + (i+1) + ". " + list.get(i));
        }
        System.out.println();
    }
    
    /** When evoked, take list of cars and the users selection
     *  Change the object as nessesary
     *  increment both the increment and the total of rates
     */
    public static void RentCar(int i, ArrayList<Car> List){
        int c = (i - 1);
        Car car = List.get(c);
        
        if (!car.getIsRented() && !car.getNeedsService()) {
            Scanner in = new Scanner(System.in);
            
            System.out.println("Enter renter's name: " );
            
            String name1 = in.next();
            String name2 = in.next();
            
            String rName = name1 + " " + name2;
            
            System.out.println("Enter renter's phone #: ");
            String rPhone = in.next();
            
            car.setRented(rName, rPhone);
            
            increment();
            plusTotal(car.getRate());
            
            in.close(); 
            
            return;
        }
        else {
            System.out.println("The " + car.getMake() + " " + car.getModel() + " is not available to rent.");
            System.out.println("Press [Enter] to continue...");
        }
        System.out.println();
        return;
    }
    
    /** When evoked, take list of cars and the users selection
     *  Change the object as nessesary
     */
    public static void returnCar(int i, ArrayList<Car> List){
        int c = (i - 1);
        Car car = List.get(c);
        
        if (car.getIsRented()){
            car.setReturned();
        }else{
            System.out.println("The " + car.getMake() + " " + car.getModel() + " is not rented and cannot be returned.");
            System.out.println("Press [Enter] to continue...");
        }
        System.out.println();
        return;
    }
    
    /** When evoked, take list of cars and the users selection
     *  Change the object as nessesary
     */
    public static void flagService(int i, ArrayList<Car> List){
        int c = (i - 1);
        Car car = List.get(c);
        
        if(!car.getNeedsService()){
            car.setNeedsService(true);
        }else{
            System.out.println("The " + car.getMake() + " " + car.getModel() + " is already flagged as needing service.");
        }
        System.out.println();
        return;
    }
    
    /** When evoked, take list of cars and the users selection
     *  Change the object as nessesary
     */
    public static void clearService(int i, ArrayList<Car> List){
        int c = (i - 1);
        Car car = List.get(c);
        
        if(car.getNeedsService()){
            car.setNeedsService(false);
        }else{
            System.out.println("The " + car.getMake() + " " + car.getModel() + " is not flagged as needing service. ");
            System.out.println("Press [Enter] to continue...");
        }
    
        System.out.println();
        return;
    }
    
    
    /** Used to increment the total number of rents
    */
    public static void increment() {
        numOfRent++;
        return;
    }
    /** Used to get the increment number
    */
    public static int getIncrement() {
        return numOfRent;
    }
    
    /** Used to increment total
    */
    public static void plusTotal(int i) {
        estRev += i;
        return;
    }
    
    /** Used to get the increment number
    */
    public static int getTotal() {
        return estRev; 
    }
    
    /** Called to close the program when needed
     */
    public static void closeProgram(){
        running = false;
    }
    
    /** Something to make a little easter egg work :)
     */
    public static int randomNum(){
     double r = Math.random()* 5;
     int rr = (int) Math.round(r);
     //System.out.println(r);
     return rr;
    }
    
    /**
      *   Hi Ali, 
      *   I wrote all of this code, and I decided to not use your code.
      *   I wanted to write it, that's all. I hope I won't get docked marks for not using it.
      *   there was an issue writing the code the array lists. I didn't write a method to write to the csv file,
      *   I would have if I started this sooner. Alas I know how to fix but I just didn't have time. ((it seems to be a theme))
     **/
    
    
    public static void carlisttest() {
        ArrayList<Car> myCars = new ArrayList<>();
        Car car;

        // Create first car object, print it, and add it to the list
        // Order of arguments: make, model, year, rate, needsService, isRented, renterName, renterPhone
        car = new Car("Volkswagen", "Beetle" , 1966, 180, false, false, "", "");
        myCars.add(car);
        
        // Create second car object, print it, and add it to the list
        car = new Car("Chevrolet", "Camaro RS", 1970, 225, false, true, "AJ Walker", "587-333-3333");
        myCars.add(car);
        
        // Print initial car list
        System.out.println("Car list created. Here is the initial state:");
        for (Car c: myCars)
        {
            System.out.println("  " + c);
        }
        
        // Rent the first car
        car = myCars.get(0);
        if (!car.getIsRented())
        {
            car.setRented("Joy Ryder", "403-999-9999");
        }
        
        // Flag the second car for servicing 
        car = myCars.get(1);
        car.setNeedsService(true);

        // And then return it
        if (car.getIsRented())
        {
            car.setReturned();
        }
                
        // Print updated car list
        System.out.println("\nCar list updated. Here is the final state:");
        for (Car c: myCars)
        {
            System.out.println("  " + c);
        }
        
        System.out.printf("End of test. Number of new rentals: %d, Revenue: $%d%n",
            Car.rentalCount, Car.rateSum);
    }
}

