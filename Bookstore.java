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
public class Bookstore {

    private String name;
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Premium> premium = new ArrayList<>();
    private ArrayList<Product> donatedProducts = new ArrayList<Product>();
    public ArrayList<Book> books = new ArrayList<>();
    public ArrayList<CD> cds = new ArrayList<>();

    /**
     * Create a new bookstore object
     *
     * @param name
     */
    public Bookstore(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the bookstore
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns members in the bookstore
     *
     * @return
     */
    public int getMembers() {
        return members.size();
    }

    /**
     * Returns all books in books ArrayList
     *
     * @return
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * Returns all cds in cds ArrayList
     *
     * @return
     */
    public ArrayList<CD> getCds() {
        return cds;
    }

    /**
     * Change/set name of bookstore
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Add a book to the books ArrayList
     *
     * @param book
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Add a cd to the cds ArrayList
     *
     * @param cd
     */
    public void addCd(CD cd) {
        cds.add(cd);
    }

    /**
     * Add new member to regular member ArrayList
     *
     * @param member
     */
    public void addMember(Member member) {
        members.add(member);
    }

    /**
     * Prints all books available from books array
     */
    public void printBooks() {
        System.out.println("**Books available**");
        for (int i = 0; i < books.size(); i++) { //go through the books ArrayList and print its info
            books.get(i).printInfo();
        }
    }

    ///////////Function///////////
    /**
     * Prints all cds available from cds array
     */
    public void printCDs() {
        System.out.println("\n");
        System.out.println("**CDs available**");
        for (int i = 0; i < cds.size(); i++) { //go through the cds ArrayList and print its info
            cds.get(i).printInfo();
        }
    }

    ///////////Function///////////
    /**
     * Create a store, add all available books and cds to the store object to be
     * available for purchase then ask the person to enter name to become member
     */
    public void setUp() {
        System.out.println("\n");
        System.out.println("***Welcome To Fernanda's Bookstore!***");
        System.out.println("\n");
        addProducts(); //make all books and cds available to use in bookstore object
        System.out.println("Become a member!");
        System.out.println("Enter your first name :D");
    }

    ///////////Function///////////
    /**
     * Ask the member if they would like to donate a cd or book, and then add
     * that product into its specific arraylist
     */
    public void donateProduct() {
        Scanner sc = new Scanner(System.in); //Scanner object to read if member choose to donate a product

        System.out.println("Will you be donating a book or cd?");
        System.out.println("1. Book");
        System.out.println("2. CD");
        int n = sc.nextInt(); //Scan member input and save as an int for switch

        //switch to determine what type of product the member will donate
        switch (n) {
            case 1:
                System.out.println("How many books will you be donating?");
                int b1 = sc.nextInt(); //scan num of books member will be donating 
                for (int i = 0; i < b1; i++) { //loop through amount of books member will be donating
                    System.out.println("Enter book name");
                    Scanner sc1 = new Scanner(System.in); //scan name of donated book
                    String booksDonated = sc1.nextLine(); //save new book as a string 'booksDonated'
                    donatedProducts.add(new Book(booksDonated, 1.0)); //create new book object using string name,
                    //new set price, add into donatedProducts ArrayList

                }
                break;

            case 2:
                System.out.println("How many cds will you be donating?");
                int c1 = sc.nextInt(); //scan num of cds member will be donating 
                for (int j = 0; j < c1; j++) { //loop through amount of cds member will be donating
                    System.out.println("Enter cd name");
                    Scanner sc2 = new Scanner(System.in); //scan name of donated cd
                    String cdsDonated = sc2.nextLine(); //save new cd as a string 'cdsDonated'
                    donatedProducts.add(new CD(cdsDonated, 5.0)); //create new cd object using string name,
                    //new set price, add into donatedProducts ArrayList
                }
                break;

            default:
                System.out.println("Please enter 1 or 2"); //if member enters anything other than 1 or 2, prompt line
        }
    }

    /**
     * Print all donated member products from donatedProducts ArrayList
     *
     */
    public void printDonatedProducts() {
        if (donatedProducts.isEmpty()) { //check if member donates at all
            System.out.println("This member has not donated anything"); //if not print line
            System.out.println("\n");
        } else { //if member does donate, add into donatedProducts ArrayList
            System.out.println("\n");
            System.out.println("This member has donated the following items:");
            for (int i = 0; i < donatedProducts.size(); i++) { //print info of all products donated 
                donatedProducts.get(i).printInfo();            //by looping through donatedproducts ArrayList
            }
        }
    }

    /**
     * Holds all books and cds in stock for member to buy from
     */
    public void addProducts() {

        //create new book objects using String name and price; add into books ArrayList 
        books.add(new Book("1. Life of Pi", 5.00));
        books.add(new Book("2. The Joy Luck Club", 5.00));
        books.add(new Book("3. Bloody Jack", 5.00));
        books.add(new Book("4. The Mysterious Benedict Society", 5.00));
        books.add(new Book("5. Of Mice and Men", 5.00));
        books.add(new Book("6. The Goldfinch", 5.00));
        books.add(new Book("7. The Five People You Meet in Heaven", 5.00));
        books.add(new Book("8. Angels & Demons", 5.00));

        //create new book objects using String name and price; add into books ArrayList 
        cds.add(new CD("1. A Night at the Opera", 10.00));
        cds.add(new CD("2. The Stranger", 10.00));
        cds.add(new CD("3. Contiuum", 10.00));
        cds.add(new CD("4. Hotel California", 10.00));
        cds.add(new CD("5. Tango in the Night", 10.00));
        cds.add(new CD("6. Abbey Road", 10.00));
        cds.add(new CD("7. No Jacket Required", 10.00));
        cds.add(new CD("8. Purple Rain", 10.00));
    }
}
