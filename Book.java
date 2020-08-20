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
public class Book extends Product {

    /**
     * Create a book object from Product class constructors
     *
     * @param name
     * @param price
     */
    public Book(String name, double price) {
        super(name, price); //call superclass constuctor
    }
}
