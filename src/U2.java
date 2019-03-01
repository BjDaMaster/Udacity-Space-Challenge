
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fornebra
 */
public class U2 extends Rocket{
    Random rand = new Random();  
    
    public U2(){
        rocketCost = 120000000;
        currentWeight = 18000;
        cargoLimit = 29000;
    }
    
    @Override
    public boolean launch(){
        if (getRand()<=4*(currentWeight/cargoLimit)){
            return false;
        }else{
            return true; 
        } 
    }
    
    @Override
    public boolean land(){
        if (getRand()<=8*(currentWeight/cargoLimit)){
            return false;
        }else{
            return true; 
        }
    }
    
    public int getRand(){
        int randNum = rand.nextInt(100) + 1; 
        return randNum; 
    }
    
}
