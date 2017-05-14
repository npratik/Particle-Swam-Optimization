/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Business.ImplementationPSO;
import Business.ParticleDrone;
import java.util.TimerTask;

/**
 *
 * @author pratik
 */
public class PSOTimerTask  extends TimerTask {
    
    private int particleNumber;
    private ParticleDrone  particle;
    private ImplementationPSO pso;
    
    public PSOTimerTask(int i, ParticleDrone p, ImplementationPSO pso){
        this.particleNumber = i;
        this.particle = p;
        this.pso = pso;
        
    }
    
    

    @Override
    public void run() {
            pso.updateSwarm(particleNumber,particle);
    }
    
    
    
}
