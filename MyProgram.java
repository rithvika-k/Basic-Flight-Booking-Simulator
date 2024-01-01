// Rithvika Kathroju 
// 9/27/2022

import java.util.Scanner; //import scanner class
import java.util.Arrays; //import arrays class for the sort method
import java.lang.ArrayIndexOutOfBoundsException; //import exception class 
import java.util.InputMismatchException; //import exception class

public class MyProgram{
    
    static Scanner s; // declare a global Scanner object
    static Ticket planeTicket; // declare a global Ticket object using the Ticket class created
    
    // start main
    public static void main(String[] args){
        s = new Scanner(System.in); // initialize Scanner object s
        
        // invoke printIntroduction() method to print out an introduction message
        printIntroduction();
        
        /*
        this while loop prompts the user to book a flight ticket, 
        if they say yes they will proceed to book a flight ticket, 
        if they say no they will be exited out of the program and it will end
        
        however, if they input an invalid answer, they will be informed that it was an invalid entry,
        and they will be prompted again and again until they enter a valid answer
        */
        while(true){
            String readyToBook; // declare variable to store if user wants to book a flight ticket or not
            
            System.out.print("\nWould you like to book your flight ticket?\nPlease enter yes or no: "); // prompts the user for whether they would like to book a flight ticket
            readyToBook = s.nextLine(); // gets user input and stores it
            
            /*
            If the user is ready to book
            then the bookTicket() method will be invoked to create a Ticket object (which will be stored in a variable),
            -- the bookTicket() method gets/stores information about the plane ticket the user is purchasing,
            the bookingConfirmation() method is invoked to allow the user to confirm their ticket, then the printBookingReceipt()
            is invoked to output the booked flight ticket, lastly the printEndMessage() method is invoked to output a goodbye message,
            it will then break out of the infinite loop
            
            Else, if the user does not want to book, then the quitProgram() method will be invoked to let the user know they quit the program, 
            it will then break out of the infinite loop
            
            Otherwise, if the user inputted a value besides 'yes' or 'no', they will be informed that it was an invalid entry,
            due to the infinite loop they will be continuously prompted until they enter a valid answer.
            */
            if(readyToBook.equalsIgnoreCase("yes")){
                planeTicket = bookTicket(); // store Ticket object in variable
                bookingConfirmation(); // invoke method
                printBookingReceipt(); // invoke method
                printEndMessage(); // invoke method
                break;
            }
            else if(readyToBook.equalsIgnoreCase("no")){
                quitProgram(); // invoke method
                break;
            }
            else{
                System.out.println("\nInvalid entry! Please try again."); // informs user about invalid entry
            }
        }
    }

    
    
    // this method (procedure) prints out the introduction message to my program
    static void printIntroduction(){
        
        System.out.println("===================================================================="); // design format
        System.out.println("✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎\n"); // design format
        System.out.println("                       FLIGHT BOOKING SYSTEM");
        System.out.println("\n✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎"); // design format
        System.out.println("===================================================================="); // design format
        
        // outputs information about the program and what it does
        System.out.println("\nWelcome to the new and improved flight booking system!");
        System.out.println("This program allows you to book a one-way flight to any main travel\ndestination! We offer our customers the best deals, and ensure they\nare travelling with airlines that offer the best experience.");
        System.out.print("\nPlease proceed to book a flight ticket");
        
    } // end printIntroduction()

    
    
    /*
    this method is the bookTicket method that returns a Ticket object (return type)
    it gathers information about the user and their ticket including their name, 
    class they are travelling in, travel destination, flight date, and flight time.
    */
    static Ticket bookTicket(){
        
        // declare string variables for the users input for the attributes of their plane ticket 
        String passengerName, classChoice, destinationChoice, dateChoice, timingChoice;
        
        // declare string arrays to hold lists of options
        // classes array holds different flight classes, destinations array holds different travel destinations, timings array holds different flight times
        String[] classes, destinations, timings;
        // declare an integer array to store the different travel date options
        int[] dates;
        
        // declare integer variables to store the hour and minutes of two different flight times
        int hour1, minutes1, hour2, minutes2;
        // declare string variables to store the two flight times
        String time1, time2;
        
        
        
        // 1st ATTRIBUTE: PASSENGER NAME
        System.out.println("\n✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸"); // design format
        System.out.println("PASSENGER INFORMATION"); 
        System.out.println("✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸"); // design format
        
        System.out.print("\nEnter your first and last name: "); // prompt user to enter their name
        passengerName = s.nextLine(); // intialize variable to get user input and store it
        
        
        
        // 2nd ATTRIBUTE: CLASS
        System.out.println("\n✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸"); // design format
        System.out.println("CLASS"); 
        System.out.println("✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸"); // design format
        
        System.out.println("\nClass Options:"); // output a subtitle
        classes = new String[]{"Coach", "Premium Economy", "Business", "First"}; // initialize classes array to store the different flight classes
        
        /*
        this for loop prints out each element in the classes array (outputs each type of flight class),
        the number of times the loop iterates is based on the length of the array (number of elements)
        */
        for(int i = 0; i < classes.length; i++){
            System.out.println((i+1) + ". " + classes[i]); // formatted output to display like a list
        }
        
        /*
        this infinite while loop prompts the user to enter the class they would like to travel in,
        if they input a valid entry (a number within range of the classes list) then the users class choice will be stored in a variable
        if they input an invalid entry, such as a number out of range in the list or a character/word, the try/catch block will
        catch the error and output an invalid entry message... since this is in a while loop the user will be prompted until they enter a valid answer
        */
        while(true){
            int classNum; // declare integer variable to store user input
            
            // prompt the user to enter what class they would like to travel
            System.out.print("\nWhat class would you like to travel in?\nPlease enter the number associated with the class: ");
            
            /*
            This try catch block tests the input entered by the user, whether they inputted a number out of the list range, or inputted a string
            if they inputted a valid entry then they will break out of the loop (no reason to ask the user again) and continue with the program,
            in the case that they inputted a string or a number out of range, they will be informed and prompted again to enter a valid answer
            */
            try{
                classNum = s.nextInt(); // variable stores user input
                
                classChoice = classes[classNum-1]; // initalize variable to store the name of the class the user picked
                break;
            }
            // the program will execute this block if the user enters a number out of range
            catch(ArrayIndexOutOfBoundsException e){
                System.out.print("\nInvalid entry! Please try again.\n"); // outputs error message to inform user
            }
            // the program will execute this block if the user enters a String instead of an integer
            catch(InputMismatchException e){
                System.out.print("\nInvalid entry! Please try again.\n"); // ouputs error message to inform user
            }
            s.nextLine(); // fixes the nextInt() glitch if either of the catch blocks get executed
        }
        s.nextLine(); // fixes the nextInt() glitch if the try block gets executed
        
        System.out.print("\nYou will travel in " + classChoice.toLowerCase() + " class!\n"); // outputs a message to inform the user their flight class, formats user option to all lowercase letters
        
        
        
        // 3rd ATTRIBUTE: TRAVEL DESTINATION
        System.out.println("\n✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸"); // design format
        System.out.println("TRAVEL DESTINATION");
        System.out.println("✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸"); // design format
        System.out.println("\nHere are the current destinations open for travel:"); // outputs a subtitle for the list of destinations that will be outputted
        destinations = new String[]{"Paris, France", "Santorini, Greece", "Bali, Indonesia", "Reykjavík, Iceland", "Cancún, Mexico", "Venice, Italy"}; // initialize destinations array to store the different travel desinations 
        
        /*
        this for loop prints out each element in the destinations array (outputs each travel destination)
        the number of times the loop iterates is based on the length of the array (number of elements)
        */
        for(int i = 0; i < destinations.length; i++){
            System.out.println((i+1) + ". " + destinations[i]); // formatted output to display like a list
        }
        
        /*
        this infinite while loop prompts the user to enter the destination they would like to travel to,
        if they input a valid entry (a number within range of the destinations list) then the users destination choice will be stored in a variable
        if they input an invalid entry, such as a number out of range in the list or a character/word, the try/catch block will
        catch the error and output an invalid entry message... since this is in a while loop the user will be prompted until they enter a valid answer
        */
        while(true){
            int destinationNum; // declare integer variable to store user input
            
            // prompt the user to enter what destination they would like to travel
            System.out.print("\nWhat destination would you like to visit?\nPlease enter the number associated with the destination: ");
            
            /*
            This try catch block tests the input entered by the user, whether they inputted a number out of the list range, or inputted a string
            if they inputted a valid entry then they will break out of the loop (no reason to ask the user again) and continue with the program 
            
            in the case that they inputted a string or a number out of range, they will be informed/prompted again to enter a valid answer
            */
            try{
                destinationNum = s.nextInt(); // variable stores user input
                
                destinationChoice = destinations[destinationNum-1]; // initalize variable to store the name of the destination the user picked
                break;
            }
            // the program will execute this block if the user enters a number out of range
            catch(ArrayIndexOutOfBoundsException e){
                System.out.print("\nInvalid entry! Please try again.\n"); // outputs error message to inform user
            }
            // the program will execute this block if the user enters a String instead of an integer
            catch(InputMismatchException e){
                System.out.print("\nInvalid entry! Please try again.\n"); // outputs error message to inform user
            }
            s.nextLine(); // fixes the nextInt() glitch if either of the catch blocks get executed
        }
        s.nextLine(); // fixes the nextInt() glitch if the try block gets executed
        
        System.out.print("\nYou are going to " + destinationChoice + "!"); // outputs a message to inform the user what destination they chose
        
        
        
        // 4th ATTRIBUTE: DEPARTURE DATE
        System.out.println("\n\n✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸"); // design format
        System.out.println("DEPARTURE DATE");
        System.out.println("✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸"); // design format
        
        System.out.println("\nHere are the dates for your one-way trip to " + destinationChoice + ":"); // outputs a subtitle for the list of dates that will be outputted
        dates = new int[5]; // initialize dates array (with specific size) to store the different flight dates 
        
        /*
        this for loop generates a random number from 1 to 30 and stores it as a new element in the dates array depending on the iteration of the loop
        the number of times the loop iterates is based on the length of the array, (the dates array only holds 5 elements)
        the for loop also ensures that there are no duplicated dates in the randomly generated list
        */
        for(int i = 0; i < dates.length; i++){
            boolean isDuplicate; // declare boolean variable to determine if there is a duplicate date
            int randomDate; // declare integer variable to store the randomly generated number in every iteration of the loop
            
            isDuplicate = false; // initalize variable and set it to false
            randomDate = randomNumGenerator(1,30); // initalize variable to store the randomly generated number
            
            /*
            this for loop checks if there are any duplicate dates
            the for loop runs until it iterates one less than the outer for loop... this is because the outer for loop is 
            generating a random number for the array at 'i', therefore you need to compare the random number with the values
            already in the array by checking the ones before position dates[i].
            */
            for(int j = 0; j < i; j++){
                /*
                this if statment checks if there is a duplicate,
                if there is then the boolean value will be set to true and the counter 'i' will be decremented by 1 since 
                there is no value for the array at that index position (it still needs to generate a random number for that index)
                */
                if(dates[j] == randomDate){
                    isDuplicate = true; // set boolean to true
                    i--; // decrement outer counter 'i'
                    break;
                }
            }
            
            /*
            this if statement will execute if there is a duplicate date, in which it will go back to the top of the for loop
            to generate another date,
            otherwise, if there is no duplicate date this block wont be executed, and will proceed to add the random date generated to the array
            */
            if(isDuplicate){
                continue;
            }
            dates[i] = randomDate; // add random date to the array at the index position of the iteration
        }
        
        Arrays.sort(dates); // sorts the dates array from least to greatest
        
        /*
        this for loop prints out each element in the dates array (outputs each travel date)
        the number of times the loop iterates is based on the length of the array (number of elements)
        */
        for(int i = 0; i < dates.length; i++){
            System.out.println((i+1) + ". October " + dates[i]); // formatted output to display like a list
        }
        
        /*
        this infinite while loop prompts the user to enter the date they would like to travel,
        if they input a valid entry (a number within range of the dates list) then the users date choice will be stored in a variable
        if they input an invalid entry, such as a number out of range in the list or a character/word, the try/catch block will
        catch the error and output an invalid entry message... since this is in a while loop the user will be prompted until they enter a valid answer
        */
        while(true){
            int travelDate; // declare integer variable to store user input
            
            // prompt the user to enter what date they would like to travel
            System.out.print("\nWhen would you like to travel to " + destinationChoice + "?\nPlease enter the number associated with your date of choice: ");
            
            /*
            This try catch block tests the input entered by the user, whether they inputted a number out of the list range, or inputted a string
            if they inputted a valid entry then they will break out of the loop (no reason to ask the user again) and continue with the program 
            in the case that they inputted a string or a number out of range, they will be informed/prompted again to enter a valid answer
            */
            try{
                travelDate = s.nextInt(); // variable stores user input
                
                dateChoice = Integer.toString(dates[travelDate-1]); // initalize variable to store the date the user picked and convert it to a string
                break;
            }
            // the program will execute this block if the user enters a number out of range
            catch(ArrayIndexOutOfBoundsException e){
                System.out.print("\nInvalid entry! Please try again.\n"); // outputs error message to inform user
            }
            // the program will execute this block if the user enters a String instead of an integer
            catch(InputMismatchException e){
                System.out.print("\nInvalid entry! Please try again.\n"); // outputs error message to inform user
            }
            s.nextLine(); // fixes the nextInt() glitch if either of the catch blocks get executed
        }
        s.nextLine(); // fixes the nextInt() glitch if the try block gets executed
        
        System.out.print("\nYou are going on October " + dateChoice + ", 2022!"); // outputs a message to inform the user what date they chose
        
        
        
        // 5th ATTRIBUTE: FLIGHT TIME
        System.out.println("\n\n✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸"); // design format
        System.out.println("FLIGHT TIME");
        System.out.println("✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸ ✸"); // design format
        
        System.out.println("\nHere are the timings for the flights to " + destinationChoice + " from Toronto:\n(24 Hr Time)\n"); // outputs a subtitle for the list of flight times that will be outputted
        timings = new String[2]; // initialize timings array (with specific size) to store the different flight times 
        
        // generates a random hour and minutes using the randomNumGenerator() for the first flight time, and then stores it in the timings array
        hour1 = randomNumGenerator(0, 12); // initilizes variable to store random number from 0 to 12 (hour). Invokes method and passes in a min and max value as arguments
        minutes1 = randomNumGenerator(10, 59); // initializes variable to store random from 10 to 59 (minutes)
        time1 = (hour1 + ":" + minutes1); // initalizes a variable to store the final time
        timings[0] = time1; // sets final time as the first element in the timings array
        
        // generates a random hour and minutes using the randomNumGenerator() for the second flight time, and then stores it in the timings array
        hour2 = randomNumGenerator(13, 23); // initilizes variable to store random number from 13 to 23 (hour). Invokes method and passes in a min and max value as arguments
        minutes2 = randomNumGenerator(10, 59); // initializes variable to store random from 10 to 59 (minutes)
        time2 = (hour2 + ":" + minutes2); // initalizes a variable to store the final time
        timings[1] = time2; // sets final time as the second element in the timings array
        
        // outputs the first and second flight time as a list for the user
        System.out.println("1. Flight 1 Time: " + time1 + "\n-----AIRLINE: Air Frontier\n"); 
        System.out.println("2. Flight 2 Time: " + time2 + "\n-----AIRLINE: Air Frontier"); 
        
        /*
        this infinite while loop prompts the user to enter the flight time they would like to travel at,
        if they input a valid entry (a number within range of the countries list) then the users flight time choice will be stored in a variable
        if they input an invalid entry, such as a number out of range in the list or a character/word, the try/catch block will
        catch the error and output an invalid entry message... since this is in a while loop the user will be prompted until they enter a valid answer
        */
        while(true){
            int timing; // declare integer variable to store user input
            
            // prompt the user to enter what time they would like to travel at
            System.out.print("\nWhat flight time would you like?\nPlease enter the number associated with the flight time: ");
            
            /*
            This try catch block tests the input entered by the user, whether they inputted a number out of the list range, or inputted a string
            if they inputted a valid entry then they will break out of the loop (no reason to ask the user again) and continue with the program 
            in the case that they inputted a string or a number out of range, they will be informed/prompted again to enter a valid answer
            */
            try{
                timing = s.nextInt(); // variable stores user input
                
                timingChoice = timings[timing-1]; // initalize variable to store the flight time the user picked
                break;
            }
            // the program will execute this block if the user enters a number out of range
            catch(ArrayIndexOutOfBoundsException e){
                System.out.print("\nInvalid entry! Please try again.\n"); // outputs error message to inform user
            }
            // the program will execute this block if the user enters a String instead of an integer
            catch(InputMismatchException e){
                System.out.print("\nInvalid entry! Please try again.\n"); // outputs error message to inform user
            }
            s.nextLine(); // fixes the nextInt() glitch if either of the catch blocks get executed
        }
        s.nextLine(); // fixes the nextInt() glitch if the try block gets executed
        
        // outputs a message that informs the user about where and when they are travelling
        System.out.print("\nYour flight to " + destinationChoice + " on October " + dateChoice + ", 2022 is at " + timingChoice);
        
        // because this method returns a Ticket object, we must pass in the recieved values as arguments to create and return a new Ticket object
        return new Ticket(passengerName, classChoice, destinationChoice, dateChoice, timingChoice);
    } // end bookTicket()

    
    
    /*
    this method (function) generates a random number between a minimum and maximum value,
    it has two integer parameters, one for the minimum value and one for the maximum value, 
    these parameters allow the generator to generate a random number from any range 
    */
    static int randomNumGenerator(int min, int max){
        int num; // declare num variable 
        
        num = (int)(Math.random() * (max - min + 1) + min); // formula to generate a random integer between the min and max values passed in 
        return num; // return the randomly generated number
    } // end randomNumGenerator()

    
    
    /*
    this method (procedure) allows the user to confirm their flight ticket, as well as makes the output neater and easier to follow
    */
    static void bookingConfirmation(){
        // prompts the user to press enter, although they can press any key, they still have to ultimatly press enter to proceed
        System.out.print("\n\nPLEASE PRESS ENTER TO BOOK YOUR FLIGHT:"); 
        s.nextLine(); // take in input, the inputted value is not useful, therefore there is no variable to store it
        
        // lets the user know they booked their ticket, and used concatenation
        // the getDestinationName() method under the Ticket class allows me to retrive the destination name of my planeTicket object (an instance of the class)
        System.out.println("You have booked your flight to " + planeTicket.getDestinationName());
    } // end bookingConfirmation()

    
    
    /*
    this method (procedure) prints out a booking receipt/ticket based on the information the inputted for their flight.
    */
    static void printBookingReceipt(){
        System.out.print("\n\nPLEASE PRESS ENTER TO PRINT YOUR BOOKING RECEIPT:"); //prompts the user to press enter in order to output the ticket
        s.nextLine(); // take in input, but it will not be stored in a variable
        
        System.out.println("\n===================================================================="); // design format 
        System.out.println("✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎\n"); // design format
        System.out.println("                          BOOKING RECEIPT\n"); // outputs title
        
        
        System.out.println("OPERATED BY: Air Frontier"); // outputs the airline
        System.out.println("FLIGHT NUMBER: AF26487\n"); // outputs flight number
        
        System.out.println("PASSENGER: " + planeTicket.getPassengerName()); // outputs passenger name using the planeTicket object and Ticket class
        System.out.println("TICKET TYPE: Adult\n"); // outputs ticket type
        
        System.out.println("FROM: Toronto, Canada"); // outputs where the flight will start from
        System.out.println("DESTINATION: " + planeTicket.getDestinationName()); // outputs the destination, where the flight will land
        System.out.println("CLASS: " + planeTicket.getUserClass()); // outputs the flight class using the planeTicket object and Ticket class
        System.out.println("DEPARTURE DATE: October " + planeTicket.getDateOfFlight() + ", 2022"); // ouputs the departure date using the planeTicket object and the Ticket class
        System.out.println("FLIGHT TIME: " + planeTicket.getTimeOfFlight()); // outputs the flight time using the planeTicket object and the Ticket class
        
        System.out.println("\n✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎️  🧳  ✈️  ☁️  🌎"); // design format
        System.out.println("===================================================================="); // design format
    } // end printBookingReceipt()

    
    
    // this method (procedure) prints out a goodbye message if the user decides that they do not want to book a ticket
    static void quitProgram(){
        System.out.println("\nYou have decided to quit the flight booking system."); // output message
        System.out.println("We hope to see you back on our program soon!");
        System.out.println("Have a great day, goodbye!");
    } // end quitProgram()

    
    
    // this method (procedure) prints out a goodbye/end of program message after the user has booked a ticker
    static void printEndMessage(){
        System.out.println("\nThank you for booking with us! We hope you enjoy your trip.\nHave a safe journey, and happy travelling!"); //output
        System.out.println("Enjoy your day, goodbye!");
    } // end printEndMessage()
    
} // end class
// end program
