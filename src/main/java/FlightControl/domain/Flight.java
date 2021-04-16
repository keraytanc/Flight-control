/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

/**
 *
 * @author Otwarte
 */
//Flight has its airplanelane, departure place and destination place.
public class Flight {
    private Airplane plane;
    private Place departure;
    private Place target;
    
    public Flight(Airplane plane, Place departure, Place target) {
        this.plane = plane;
        this.departure = departure;
        this.target = target;
    }
    
    @Override
    public String toString() { 
        return this.plane + " (" + this.departure + "-" + this.target + ")";
    }
    
}
