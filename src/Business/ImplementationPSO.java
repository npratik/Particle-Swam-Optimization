/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

//import static Business.FitnessEvaluation.generateRandomData;
import Visualization_PSO.VisualizationPso;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author pratik
 */
public class ImplementationPSO {
    
    private int swarmSize;
    private Vector<ParticleDrone> swarm;
    
    private double const1 = 2.0;
    private double const2 = 2.0;
    private double inertia = 1.0;
    private double r1 = Math.random();
    private double r2 = Math.random();
    
    private ParticleDrone targetBlock;
    
    private Graphics graphics;
    private VisualizationPso visualPso;
    
    public ImplementationPSO( int swarmSize, Vector<ParticleDrone> swarmVector,VisualizationPso visualPso){ //, Graphics graphics){
        this.swarmSize = swarmSize;
        this.swarm = swarmVector;
        this.visualPso = visualPso;
        
    }
    private double[] particleBest;
    
    private Position particleBestPostion;
    private Velocity particleBestVelocity;
    
    private double globalBest; 
    
    private Position globalBestPosition;
    private int mainIterationCount;
    
    
    
    
    
    private int counter =1;//= 0;
     private FitnessEvaluation fitness;
     
     public void updatePositions(){
         
         visualPso.getGraphics().setColor(Color.red);
         visualPso.getGraphics().fillRect(0, 0, visualPso.getWidth(), visualPso.getHeight());
         targetBlock.drawParticleDrone(visualPso.getGraphics(),Color.ORANGE,targetBlock.getPosition().getPosition()[0], targetBlock.getPosition().getPosition()[1]);
         for(ParticleDrone p : swarm ){
             
             p.drawParticleDrone(visualPso.getGraphics(), Color.GREEN,p.getPosition().getPosition()[0], p.getPosition().getPosition()[1]);
             
         }
     }
    
    
    
    
    public void createSwarm(){
        
       

        double xMinimum = 15;//67.05;
        double xMaximum = 20;//73.45;
        double yMinimum = 15;//74.23;
       
        double yMaximum = 20;//81.34;
        double vMinimum = 1;
        double vMaximum = 2;
        
            targetBlock  = new ParticleDrone();
            double[] targetPos = new double[2];
            targetPos[0] = 40;//generateRandomData(xMinimum, xMaximum);
            targetPos[1] = 42;//generateRandomData(yMinimum, yMaximum);
            targetBlock.setPosition(new Position(targetPos));
            
            
            fitness = new FitnessEvaluation(targetBlock);
            particleBest = new double[swarmSize];
       for(int j=0; j< swarmSize; j++){
            ParticleDrone p = new ParticleDrone();
            
            
            //2D Array
            double[] pos = new double[2];
            pos[0] = generateRandomData(xMinimum, xMaximum);
            pos[1] = generateRandomData(yMinimum, yMaximum);
            p.setPosition(new Position(pos));
            p.setpBestPosition(p.getPosition());
            
            double [] vel = new double[2];
            vel[0] = generateRandomData(vMinimum, vMaximum);
            vel[1] = generateRandomData(vMinimum, vMaximum);
            p.setVelocity(new Velocity(vel));
            //fitness
            p.setFitnessValue(fitness.calculateFitnessValue(p));
            
            p.setpBest(p.getFitnessValue());
            particleBest[j] = p.getpBest();
            
            swarm.add(p);
        }
       
       updatePositions();
       
        globalBest = particleBest[0];
        globalBestPosition = swarm.get(0).getPosition();
        
       for(int j=1;j<swarmSize;j++){
           
           if(globalBest>particleBest[j]){
               globalBest = particleBest[j];
               globalBestPosition = swarm.get(j).getPosition();
           }
           
           
       }
            
            
    }
    
    public void printSwarm(){
        
        System.out.println("------------- printSwarm start-------------------------");
        for(int i=0; i<swarmSize; i++){
            ParticleDrone p = swarm.get(i);
            System.out.println("Particle: "+i);
            System.out.println("x: "+ p.getPosition().getPosition()[0]);
            System.out.println("y: "+ p.getPosition().getPosition()[1]);
            System.out.println("velocity x: " + p.getVelocity().getVelocity()[0]);
            System.out.println("velocity y: "+ p.getVelocity().getVelocity()[1]);
            System.out.println("pBest:"+ p.getpBest());
            System.out.println("pBest Position: x: "+ p.getpBestPosition().getPosition()[0]);
            System.out.println("pBest Position: y: "+ p.getpBestPosition().getPosition()[1]);
            
            System.out.println("--------------------------------------");
        }
        System.out.println("------------- printSwarm end-------------------------");
    }
    
    public static double generateRandomData(double min, double max){
        Random r = new Random();
        double result = min + (max - min) * r.nextDouble();
        
        return result;
    }

    /**
     * @return the globalBest
     */
    public double getGlobalBest() {
        return globalBest;
    }

    /**
     * @param globalBest the globalBest to set
     */
    public void setGlobalBest(double globalBest) {
        this.globalBest = globalBest;
    }
    
   

    /**
     * @return the globalBestPosition
     */
    public Position getGlobalBestPosition() {
        return globalBestPosition;
    }

    /**
     * @param globalBestPosition the globalBestPosition to set
     */
    public void setGlobalBestPosition(Position globalBestPosition) {
        this.globalBestPosition = globalBestPosition;
    }
    
    //public printPositionValues( ParticleDrone p){
        
    //}
    
     public void updateSwarm( int particleNumber, ParticleDrone particle){
         
         
          if(  counter > swarmSize){
                printSwarm();


              
              int x=0;
              
              for( int i=1;i<swarmSize;i++){
                  
                if( particleBest[x] > particleBest[i]){
                    x=i;
                }
              }
              
            
            System.out.println("Global Min Value:"+particleBest[x] );
            System.out.println("Previous gbest values:"+globalBest);
            System.out.println("Iteration Count:"+mainIterationCount);
            
              
             if(globalBest > particleBest[x]) {
              globalBest = particleBest[x];
              globalBestPosition = swarm.get(x).getPosition();
             }
               
              counter=0;
              updatePositions();
              mainIterationCount++;
          }
         
          
          counter++;
         
         
         
         
         double[] newVelocity = new double[2];
               
               newVelocity[0] = (inertia * particle.getVelocity().getVelocity()[0]) +
                                 (r1 * const1) * (particle.getpBestPosition().getPosition()[0] - particle.getPosition().getPosition()[0]) +
                                 (r2 * const2) * (globalBestPosition.getPosition()[0] - particle.getPosition().getPosition()[0]);
                
               
                newVelocity[1] = (inertia * particle.getVelocity().getVelocity()[1]) +
                                 (r1 * const1) * (particle.getpBestPosition().getPosition()[1] - particle.getPosition().getPosition()[1]) +
                                 (r2 * const2) * (globalBestPosition.getPosition()[1] - particle.getPosition().getPosition()[1]);
               
                particle.setVelocity(new Velocity(newVelocity));
                
                //update new postion
                
                double[] newPos = new double[2];
                newPos[0] = particle.getPosition().getPosition()[0] + newVelocity[0];
                newPos[1] = particle.getPosition().getPosition()[1] + newVelocity[1];
                particle.setPosition(new Position(newPos));
               double fitnessValue;
               
               fitnessValue = fitness.calculateFitnessValue(particle);
               
               if(particle.getpBest() > fitnessValue){
                    particle.setFitnessValue(fitnessValue); 
                    particle.setpBest(fitnessValue);
                    particle.setpBestPosition(particle.getPosition());
                }
                
                
                particleBest[particleNumber] =  particle.getpBest();
         
               
     }
}
