
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fornebra
 */
public class Simulation {
    
    public ArrayList<Item> loadItemsPerPhase(String fileName) throws FileNotFoundException{
        Scanner scan = new Scanner(new File(fileName)); 
        ArrayList<Item> items = new ArrayList<>(); 
        
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] split = line.split("=");
            //System.out.print(line);
            //System.out.print(split[0]);
            //System.out.println(split[1]);

            Item item = new Item(split[0], Integer.parseInt(split[1]));
            items.add(item);
        }
        return items; 
    }
    
    public ArrayList<Rocket> loadU1(ArrayList<Item> items){
        ArrayList<Rocket> u1Rockets = new ArrayList<>(); 
        Rocket rocket = new U1();
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                u1Rockets.add(rocket);
                rocket = new U1();
                rocket.carry(item);
            }
            if(!iterator.hasNext()){
                u1Rockets.add(rocket);
            }
        }

        return u1Rockets;
    }
    
    public ArrayList<Rocket> loadU2(ArrayList<Item> items){
        ArrayList<Rocket> u2Rockets = new ArrayList<>(); 
        Rocket rocket = new U2();
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                u2Rockets.add(rocket);
                rocket = new U2();
                rocket.carry(item);
            }
            if(!iterator.hasNext()){
                u2Rockets.add(rocket);
            }
        }
        

        return u2Rockets;
    }
    
    public double runSimulation(ArrayList<Rocket> rockets){
        int currentRocket = 0; 
        double budget = 0; 
        int failedAttempts = 0; 
        
        for(int i = 0; i<rockets.size(); i++){
            currentRocket++;
            budget += rockets.get(i).rocketCost; 
            
            if(!rockets.get(i).launch()){
                budget += rockets.get(i).rocketCost; 
                failedAttempts++; 
                i--; 
            }else{
                if(!rockets.get(i).land()){
                    budget += rockets.get(i).rocketCost; 
                    failedAttempts++; 
                    i--; 
                }
            }
        }
//        out.println("Rockets Launched: " + currentRocket);
//        out.println("Rockets Crashed: " + failedAttempts); 
//        out.printf("Total Budget: $%,.0f\n", budget); 
        
        return budget; 
    }
    
    public double runSimXTimes(int xTimes, ArrayList<Rocket> rockets){
        double totalBudget = 0; 
        for(int i = 0; i<xTimes; i++){
            totalBudget += runSimulation(rockets); 
        }
        return totalBudget/xTimes; 
    }
    
}
