/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.ui;
import FlightControl.logic.AirportControl;
import FlightControl.domain.Flight;
import FlightControl.domain.Airplane;
import FlightControl.domain.Place;
import java.util.Scanner;

/**
 *
 * @author Otwarte
 */
public class UI {
    private Scanner scanner;
    private AirportControl control;
    
    //creating two objects: scanner for user input and Airport control managing functionality of the program
    public UI(){
        this.scanner = new Scanner(System.in);
        this.control = new AirportControl();
    }
    //starting a program
    public void start(){
        startAssetControl();
        startFlightControl();
    }
    
    //Part of the program responsible for entering data
    public void startAssetControl() {
        
        //loop allowing to enter data untill user quits
        while (true) {
            System.out.print("Airport Asset Control" + "\n" + "[1] Add an airplane" + "\n" +
            "[2] Add a flight" + "\n" + "[x] Exit Airport Asset Control" + "\n" + "> ");
            String command = scanner.nextLine();
            System.out.println();
            
            if (command.equals("1")) {
                addingAirplane();
            } else if (command.equals("2")) {
                addingFlight();   
            } else if (command.equals("x")) {
                break;
            } else {
                continue;
            }
        }
    }
    
    //part of the program responsible for printing data
    public void startFlightControl() {
        while (true) {
            System.out.print("Flight Control" + "\n" + "[1] Print airplanes" + "\n" + 
                    "[2] Print flights" + "\n" + "[3] Print airplane details" + "\n" + "[x] Quit" + "\n" + "> ");
            String command = scanner.nextLine();
            System.out.println();
            
            if (command.equals("1")) {
                this.control.printAirplanes();
            } else if (command.equals("2")) {
                this.control.printFlights();
            } else if (command.equals("3")) {
                airplaneDetails();
            } else if (command.equals("x")) {
                break;
            } else {
                System.out.println("incorrect command");
            }
        }
    }
    
    //method asking user for data and adding a plane to the list
    public void addingAirplane() {
        
        //entering data
        System.out.print("Give the airplane id: ");
        String newID = scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int newCapacity = Integer.valueOf(scanner.nextLine());
        
        //creating new airplane and adding it to the list
        Airplane newPlane = new Airplane(newID, newCapacity);
        this.control.addAirplane(newPlane);
    }
    //adding new flight to a list
    public void addingFlight() {
        
        //defining variable necessary for adding a flight
        String airplaneID = "";
        String departure = "";
        String destination = "";
        
        //loop to repeat process in case of the incorrect airplane ID
        while(true) {
            System.out.print("Give the airplane id: ");
            airplaneID = scanner.nextLine(); 
            
            //checking if airplane is on the list. If no loop repeated
            if (!(this.control.checkIfAirplaneAdded(airplaneID))) {
                System.out.println("No airplane with the id " + airplaneID + ".");
                continue;
            }
            break;
        }
        
        //asking for departure and putting it on a list if absent
        System.out.print("Give the departure airport id: ");
        departure = scanner.nextLine();
        this.control.addPlace(new Place (departure));
        
        //asking for destination and putting it on a list if absent
        System.out.print("Give the target airport id: ");
        destination = scanner.nextLine();
        this.control.addPlace(new Place (destination));
        
        //creating a new flight
        Airplane airplane = this.control.getAirplane(airplaneID);
        Place starting = this.control.getPlace(departure);
        Place target = this.control.getPlace(destination);
        Flight newFlight = new Flight(airplane, starting, target);
        
        //adding a flight
        this.control.addFlight(newFlight);
    }
    
    public void airplaneDetails() {
        
        //defining variables necessary for action
        String id = "";
        
        //loop in case of incorrect ID
        while(true) {
            System.out.print("Give the airplane id: ");
            id = scanner.nextLine();
            
            //checking if airplane is added
            if (!(this.control.checkIfAirplaneAdded(id))) {
                System.out.println("incorrect id");
                continue;
            }
            break;
        }
        //printing details
        System.out.println(this.control.getAirplane(id));
    }
    
     
}
