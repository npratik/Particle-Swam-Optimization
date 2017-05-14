/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_pso;

import Business.ImplementationPSO;
import Business.ParticleDrone;
import Threads.PSOTimerTask;
import Visualization_PSO.VisualizationPso;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import javax.swing.JFrame;

/**
 *
 * @author pratik
 */
public class Project_PSO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int swarmSize = 30;//3;//15;
        Vector<ParticleDrone> swarm = new Vector<ParticleDrone>();
        
        ArrayList<TimerTask> timerList = new ArrayList<TimerTask>();
        
        VisualizationPso visualPso = new VisualizationPso();
        
        
        ImplementationPSO pso = new ImplementationPSO(swarmSize,swarm,visualPso );
        pso.createSwarm();
        
        
        
        Timer timer = new Timer(true); 
        
    
        
        // ArrayList to hold the Timer task created for each swarm particle
        
        
        for(int i=0;i<swarmSize;i++){
            
            PSOTimerTask task = new PSOTimerTask(i,swarm.get(i),pso);
            timerList.add(task);
        
        }
        
        for( TimerTask currentTask : timerList ){
            //timer.scheduleAtFixedRate(currentTask, 0, 10000);
            //timer.scheduleAtFixedRate(currentTask, 1000, 5000);
            //timer.scheduleAtFixedRate(currentTask, 500, 1000);
            timer.scheduleAtFixedRate(currentTask, 0, 500);
            
            
        }
        
        
        
        try {
            //Thread.sleep(75000);
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        timer.cancel();
    }
    
}
