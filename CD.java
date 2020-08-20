/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoremanagementstart;

/**
 *
 * @author Fernanda Sanchez
 */
public class CD extends Product {

    /**
     * Create a cd object from Product class constructors
     *
     * @param title
     * @param price
     */
    public CD(String title, double price) {
        super(title, price); //call superclass constuctor
    }
}
