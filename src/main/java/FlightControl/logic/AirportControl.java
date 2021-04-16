/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;
import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;
import java.util.HashMap;

/**
 *
 * @author Otwarte
 */

    //Program needs a list of airplanes and list of flights because main functions consists of adding and printing those lists
    //it also has a list of places.
public class AirportControl {
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Flight> flights; 
    private HashMap<String, Place> places;
    
    public AirportControl() {
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
        this.places = new HashMap<>();
    }
    //adding airplane
    public void addAirplane(Airplane airplane) {
       this.airplanes.putIfAbsent(airplane.getID(), airplane);
    }
    //adding a flight
    public void addFlight(Flight flight) {
        this.flights.put(flight.toString(), flight);   
    }
    
    //adding a place
    public void addPlace(Place place) {
        this.places.putIfAbsent(place.getID(), place);
    }
    
    //printing all added airplanes
    public void printAirplanes() {
        for(Airplane plane: this.airplanes.values()) {
            System.out.println(plane);
        }
    }
    //printing all added flights
    public void printFlights() {
        for(Flight flight: this.flights.values()) {
            System.out.println(flight);
        }
    }
    
    //checking if airplane is already added
    public boolean checkIfAirplaneAdded(String ID) {
        return this.airplanes.containsKey(ID);
    }
    
    //getting airplane based on ID
    public Airplane getAirplane(String ID) {
        return this.airplanes.get(ID);
    }
    
    //Getting a place
    public Place getPlace(String ID) {
        return this.places.get(ID);
        
    }
    
    
    
}
