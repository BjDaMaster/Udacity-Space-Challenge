/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fornebra
 */
public interface Spaceship {
    //Decides if the spaceship will successfully launch / crash
    boolean launch();
    //Decides if the spaceship will successfully land / crash
    boolean land();
    //Places an item into the spaceship to transport
    int carry(Item item);
    //Decides whether or not the spaceship can carry more weight
    boolean canCarry(Item item);

}
