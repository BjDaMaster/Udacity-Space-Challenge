/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fornebra
 */
public class Rocket implements Spaceship {
    int currentWeight; //field that stores rocket's current weight
    int cargoLimit; //field that stores maximum amount of weight the rocket can hold
    int rocketCost; //field that stores the overall cost of the rocket
    
    @Override
    public boolean launch(){
        return true; 
    }
    
    @Override
    public boolean land(){
        return true; 
    }
    
    @Override
    public int carry(Item item){
        currentWeight = currentWeight + item.weight; 
        return currentWeight; 
    }

    @Override
    public boolean canCarry(Item item){
        int startingWeight = currentWeight + item.weight; 
        return startingWeight <= cargoLimit; 
    }
}
