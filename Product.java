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
public class Product {

    private String creator;
    private String title;
    private double price;

    /**
     * Create new product naming type of product and its initial price
     *
     * @param title
     * @param price
     */
    public Product(String title, double price) {
        this.title = title;
        this.price = price;
    }

    /**
     * Get creator of a specific product
     *
     * @return
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Return the title of the specific product as a string
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Return price of the product as a double
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set price of a product
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Prints the title of book/cd and its price
     */
    public void printInfo() {
        System.out.println(this.getTitle() + " for " + this.getPrice());
    }
}
