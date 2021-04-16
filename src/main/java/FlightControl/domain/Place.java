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
//Place consists of its ID. e.g Warsaw is WAW.
public class Place {
    private String ID;
    
    public Place(String ID) {
        this.ID = ID;
    }
    
    public String getID() {
        return this.ID;
    }
    
   @Override
   public String toString() {
       return this.ID;
   }
}
