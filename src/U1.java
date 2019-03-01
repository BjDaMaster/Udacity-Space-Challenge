
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
public class U1 extends Rocket{
    Random rand = new Random(); 
    
    public U1(){
        rocketCost = 100000000;
        currentWeight = 10000;
        cargoLimit = 18000;  
    }
    
    @Override
    public boolean launch(){
        if(getRand()<=5*(currentWeight/cargoLimit)){
            return false;
        }else{
            return true; 
        }
    }
    
    @Override
    public boolean land(){
        if (getRand()<=1*(currentWeight/cargoLimit)){
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
