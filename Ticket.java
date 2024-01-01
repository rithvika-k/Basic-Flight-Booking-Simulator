public class Ticket { // class Ticket

    // declare instance fields, attributes of the class (a Ticket object)
    private String passengerName, userClass, destinationName, dateOfFlight, timeOfFlight;
    
    // constructor method, has the passenger name, flight class, destination, flight date, and time as String parameters
    public Ticket(String name, String flightClass, String destination, String date, String time){
        // set the values for each of the instance fields/attributes based on the arguments passed in
        this.passengerName = name;
        this.userClass = flightClass;
        this.destinationName = destination;
        this.dateOfFlight = date;
        this.timeOfFlight = time;
    }
    
    // this method gets the passenger name on the Ticket object and returns it
    String getPassengerName(){
        return this.passengerName; // returns the passenger name on the Ticket object
    }
    
    // this method gets the flight class on the Ticket object and returns it
    String getUserClass(){
        return this.userClass; // returns the flight class name on the Ticket object
    }
    
    // this method gets the destination name on the Ticket object and returns it
    String getDestinationName(){
        return this.destinationName; // returns the destination name on the Ticket object
    }
    
    // this method gets the flight date on the Ticket object and returns it
    String getDateOfFlight(){
        return this.dateOfFlight; // returns the flight date on the Ticket object
    }
    
    // this method gets the flight time on the Ticket object and returns it
    String getTimeOfFlight(){
        return this.timeOfFlight; // returns the flight time on the Ticket object
    }
} // end class Ticket