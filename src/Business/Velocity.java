/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author pratik
 */
public class Velocity {
    
    private double [] velocity;
    
    public Velocity( double [] vel){
        this.velocity = vel;
    }

    /**
     * @return the velocity
     */
    public double [] getVelocity() {
        return velocity;
    }

    /**
     * @param velocity the velocity to set
     */
    public void setVelocity(double [] velocity) {
        this.velocity = velocity;
    }
    
    
    
    
    
}
