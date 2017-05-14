/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author pratik
 */
public class ParticleDrone {
    
    private Velocity velocity;
    private Position position;
    private double size;
    private double fitnessValue;
    private double pBest; 
    private Position pBestPosition;
    
    

    /**
     * @return the velocity
     */
    public Velocity getVelocity() {
        return velocity;
    }

    /**
     * @param velocity the velocity to set
     */
    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    /**
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @return the size
     */
    public double getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * @return the fitnessValue
     */
    public double getFitnessValue() {
        return fitnessValue;
    }

    /**
     * @param fitnessValue the fitnessValue to set
     */
    public void setFitnessValue(double fitnessValue) {
        this.fitnessValue = fitnessValue;
    }

    /**
     * @return the pBest
     */
    public double getpBest() {
        return pBest;
    }

    /**
     * @param pBest the pBest to set
     */
    public void setpBest(double pBest) {
        this.pBest = pBest;
    }

    /**
     * @return the pBestPosition
     */
    public Position getpBestPosition() {
        return pBestPosition;
    }

    /**
     * @param pBestPosition the pBestPosition to set
     */
    public void setpBestPosition(Position pBestPosition) {
        this.pBestPosition = pBestPosition;
    }
    
    
    public void drawParticleDrone( Graphics gh, Color c,double x, double y){
        
        int  x_coordinate = (int) x *5;
        int  y_coordinate = (int) y*5;
        gh.setColor(c);
        gh.drawOval(x_coordinate, y_coordinate,  20, 20);
        
        
    }
    
    
    
}
