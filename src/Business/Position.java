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
public class Position {
    
    private double [] position;
    
    public Position( double[] position){
        this.position = position;
    }

    /**
     * @return the position
     */
    public double[] getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(double[] position) {
        this.position = position;
    }
    
    public int getMinimumPositionValue( double[] pos){
        
        double position = pos[0];
        
        int minPosition = 0;
        
        for(int i=0;i<pos.length;i++){
            if(pos[i]< position){
                minPosition = i;
                position = pos[i];
            }
        }
        
        return minPosition;
        
        
        
    }
    
    
}
