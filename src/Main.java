
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fornebra
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Simulation sim = new Simulation();
        int numOfAttempts = 100000000; 
        ArrayList<Item> items = sim.loadItemsPerPhase("phase1.txt"); 
        ArrayList<Rocket> u1Rockets = sim.loadU1(items);
        ArrayList<Rocket> u2Rockets = sim.loadU2(items);
        
        out.println("Starting Phase 1"); 
        
//        out.println("\nU1:"); 
//        sim.runSimulation(u1Rockets);
//        
//        out.println("\nU2:"); 
//        sim.runSimulation(u2Rockets);
        
        double averageU1Cost = sim.runSimXTimes(numOfAttempts, u1Rockets); 
        double averageU2Cost = sim.runSimXTimes(numOfAttempts, u2Rockets);
        
        if(averageU1Cost < averageU2Cost){
            System.out.printf("In %d attempts, it is better to use the U1 Rocket"
                    + " with an average cost of $%,.0f\n", numOfAttempts, averageU1Cost);
        }else{
            System.out.printf("In %d attempts, it is better to use the U2 Rocket"
                    + " with an average cost of $%,.0f\n", numOfAttempts, averageU2Cost);
        }
         
        items = sim.loadItemsPerPhase("phase2.txt"); 
        u1Rockets = sim.loadU1(items);
        u2Rockets = sim.loadU2(items);
        
        out.println("\n---------------------------------------------------------");
        out.println("\nStarting Phase 2"); 
        
//        out.println("\nU1:"); 
//        sim.runSimulation(u1Rockets);
//        
//        out.println("\nU2:"); 
//        sim.runSimulation(u2Rockets);

        averageU1Cost = sim.runSimXTimes(numOfAttempts, u1Rockets); 
        averageU2Cost = sim.runSimXTimes(numOfAttempts, u2Rockets);
        
        if(averageU1Cost < averageU2Cost){
            System.out.printf("In %d attempts, it is better to use the U1 Rocket"
                    + " with an average cost of $%,.0f\n", numOfAttempts, averageU1Cost);
        }else{
            System.out.printf("In %d attempts, it is better to use the U2 Rocket"
                    + " with an average cost of $%,.0f\n", numOfAttempts, averageU2Cost);
        }
    }
}
