/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Particle;

import java.util.Random;


/**
 *
 * @author pratik
 */
public class FitnessEvaluation {
    
    ParticleDrone particleDrone;
    
    ParticleDrone targetP;
    
    int x_min = 10,x_max = 20;
    int y_min = 10, y_max = 20;
    int v_min = 1,v_max = 10 ;
    
    public FitnessEvaluation( ParticleDrone targetP) {  
        this.targetP = targetP;
        
    }
    
    public double calculateFitnessValue( ParticleDrone p ){
            double result;
            double diff_x;
            double diff_y;
        
         
        diff_x = Math.abs(p.getPosition().getPosition()[0] - targetP.getPosition().getPosition()[0]);
        diff_y = Math.abs(p.getPosition().getPosition()[1] - targetP.getPosition().getPosition()[1]);
        result = Math.sqrt((Math.pow(diff_x, 2)) + (Math.pow(diff_y, 2)));
        
        return  result;
    }
}

