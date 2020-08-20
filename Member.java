/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoremanagementstart;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fernanda Sanchez
 */
public class Member {

    private String name;
    protected String paymentMethod;
    private boolean isPremium = false;
    protected double totalSpent = 0;
    public ArrayList<Product> productsPurchased = new ArrayList<>();
    public ArrayList<Book> booksPurchased = new ArrayList<>();
    public ArrayList<CD> cdsPurchased = new ArrayList<>();

    /**
     * Create a new member using name and payment method
     *
     * @param name
     * @param paymentMethod
     */
    public Member(String name, String paymentMethod) {
        this.name = name;
        totalSpent = 0;
    }

    /**
     * Return string name of a member
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Return boolean of whether a member is premium or not
     *
     * @return
     */
    public boolean isPremium() {
        return isPremium;
    }

    /**
     * Return double of total spent by member
     *
     * @return
     */
    public double getTotalSpent() {
        return totalSpent;
    }

    /**
     * Return all products purchased by member
     *
     * @return
     */
    public ArrayList<Product> getProductsPurchased() {
        return productsPurchased; //return all products purchased from productsPurchased ArrayList
    }

    /**
     * Return all books purchased by member
     *
     * @return
     */
    public ArrayList<Book> getBooksPurchased() {
        return booksPurchased; //return all books purchased from booksPurchased ArrayList
    }

    /**
     * Return all cds purchased by member
     *
     * @return
     */
    public ArrayList<CD> getCdsPurchased() {
        return cdsPurchased; //return all cds purchased from cdsPurchased ArrayList
    }

    ///////////Function///////////
    /**
     * Purchase a book from books ArrayList and add into booksPurchased
     * ArrayList
     *
     * @param product
     */
    public void purchaseBook(Book product) {
        booksPurchased.add(product); //add chosen book into booksPurchased ArrayList
        totalSpent += product.getPrice(); //add total spent with price of product
        System.out.println(this.getName() + " has purchased " //print member, book purchased, and its price
                + product.getTitle() + " for $" + product.getPrice());
        System.out.println("\n");
    }

    /**
     * Purchase a cd from cds ArrayList and add into cdsPurchased ArrayList
     *
     * @param product
     */
    public void purchaseCD(CD product) {
        cdsPurchased.add(product); //add chosen cd into cdsPurchased ArrayList
        totalSpent += product.getPrice(); //add total spent with price of product
        System.out.println(this.getName() + " has purchased " //print member, cd purchased, and its price
                + product.getTitle() + " for $" + product.getPrice());
    }

    /**
     * Return a book already purchased from booksPurchased ArrayList and
     * subtract price from total spent
     *
     * @param product
     */
    public void returnBook(Book product) {
        booksPurchased.remove(product); //remove book from booksPurchased ArrayList
        totalSpent -= product.getPrice(); //decrement total spent with price of book
    }

    /**
     * Return a book already purchased from booksPurchased ArrayList and
     * subtract price from total spent
     *
     * @param product
     */
    public void returnCD(CD product) {
        cdsPurchased.remove(product); //remove cd from cdsPurchased ArrayList
        totalSpent -= product.getPrice(); //decrement total spent with price of cd
    }

    /**
     * Set name of the member using a string
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set total spent of new member using a double
     *
     * @param totalSpent
     */
    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    /**
     * Prints the total amount of money spent by the member including their
     * premium membership if applicable
     */
    public void printTotalSpent() {
        System.out.println(this.getName() + " has spent $" + this.getTotalSpent()); //print member and their total spent
    }

    ///////////Function///////////
    /**
     * Print all the books and cds individually the new member has purchased
     */
    public void printPurchasedProducts() {
        printPurchasedBooks(); //print all books purchased from booksPurchased ArrayList
        System.out.println("\n");
        printPurchasedCDs(); //print all cds purchased from cdsPurchased ArrayList
        System.out.println("\n");

    }

    ///////////Function///////////
    /**
     * Print the books purchased from the ArrayList booksPurchased & info of
     * books purchased
     */
    public void printPurchasedBooks() {
        if (booksPurchased.isEmpty()) { //if statement to determine if member has purchased any books
            System.out.println(this.getName() + " has no books"); //if no books purchased, print line
        } else { //if books are purchased, print all books purchased name's
            System.out.println("This member has the following books:");
            for (int i = 0; i < booksPurchased.size(); i++) { //get all purchased books
                System.out.println(booksPurchased.get(i).getTitle());
            }
        }
    }

    /**
     * Print the cds purchased from the ArrayList cdsPurchased & info of cds
     * purchased
     */
    public void printPurchasedCDs() {
        if (cdsPurchased.isEmpty()) { //if statement to determine if member has purchased any cds
            System.out.println(this.getName() + " has no cds"); //if no cds purchased, print line
        } else { //if cds are purchased, print all cds purchased name's
            System.out.println("This member has the following cds:");
            for (int i = 0; i < cdsPurchased.size(); i++) { //get all purchased cds
                System.out.println(cdsPurchased.get(i).getTitle());
            }
        }
    }
}
