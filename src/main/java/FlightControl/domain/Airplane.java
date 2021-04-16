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
//Airplane consists of it's ID and passager capacity
public class Airplane {
    private String ID;
    private int capacity;
    
    public Airplane(String ID, int capacity) {
        this.ID = ID;
        this.capacity = capacity;
    }
    
    public String getID() {
        return this.ID;
    }
    
    @Override
    public String toString() {
        return this.ID + " (" + this.capacity + " capacity)";
    }
    
}
