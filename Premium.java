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
public class Premium extends Member {

    private String paymentMethod;
    private boolean feePaid;
    private double discount = .3;

    /**
     * Create new Premium member using Member constructors and charge a $20 fee
     *
     * @param name
     * @param paymentMethod
     */
    public Premium(String name, String paymentMethod) {
        super(name, paymentMethod);
        totalSpent = 20; //add $20 to totalSpent for becoming Premium
    }

    /**
     * Return payment method member gave
     *
     * @return
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Return whether premium member paid their $20 fee
     *
     * @return
     */
    public boolean isFeePaid() {
        return feePaid;
    }

    /**
     * Set payment method of new member to their input
     *
     * @param paymentMethod
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Set premium fee paid to true or false depending if was paid
     *
     * @param feePaid
     */
    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
    }

    ///////////Function///////////
    /**
     * Purchase book from books ArrayList by adding to booksPurchased ArrayList
     *
     * @param product
     */
    @Override
    public void purchaseBook(Book product) {
        double discount = (1 - this.discount); //apply discount of 30% for new members 
        booksPurchased.add(product); //add purchased book to booksPurchased ArrayList
        totalSpent += (product.getPrice() * discount); //apply discount to actual price, add to totalSpent
        System.out.println(this.getName() + " has purchased " //print member name, product purchased + price
                + product.getTitle() + " for $" + (product.getPrice() * discount));
        System.out.println("\n");
    }

    /**
     *
     * @param product
     */
    @Override
    public void purchaseCD(CD product) {
        double discount = (1 - this.discount); //apply discount of 30% for new members 
        cdsPurchased.add(product); //add purchased cd to cdsPurchased ArrayList
        totalSpent += (product.getPrice() * discount); //apply discount to actual price, add to totalSpent
        System.out.println(this.getName() + " has purchased " //print member name, product purchased + price
                + product.getTitle() + " for $" + (product.getPrice() * discount));
    }
}
