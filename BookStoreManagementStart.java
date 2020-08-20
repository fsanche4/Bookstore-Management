/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoremanagementstart;

import java.util.Scanner;

/**
 *
 * @author Fernanda Sanchez
 */

///////////////////Major Functions///////////////////
//setUp(); // Welcomes to bookstore, adds all products available to bookstore
//purchaseBook(book); // Member buys a book and its added to their purchased books arraylist 
//purchaseCD(cd); // Member buys a cd and its added to their purchased cds arraylist
//printDonatedProducts(); // Print all donated member products from donatedProducts ArrayList
//donateProduct(); // Ask member if they want to donate cd or book,then add product into its specific arraylist
//printPurchasedProducts(); // Print all the books and cds individually the new member has purchased

public class BookStoreManagementStart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Bookstore store = new Bookstore("store"); //create a new bookstore "store" to process all transactions and functions
        Member theMember = null; //create temporary member to hold all info on new members and their transactions
        store.setUp(); //call the setUp method to begin "open shop"

        Scanner scan = new Scanner(System.in); //new Scanner object to hold input from member

        Scanner nameScan = new Scanner(System.in);
        String name = nameScan.nextLine(); //store the scanner object in a string object called name
        System.out.println("Enter payment method");
        Scanner payment = new Scanner(System.in);
        String method = payment.nextLine();
        System.out.println("Would you like to be premium? (Y/N)");
        char choice = scan.nextLine().charAt(0); //scan the first letterto determine if customer wants to be premium
        if ((choice == 'y') || (choice == 'Y')) { //if statment to add member to premium arraylist & charge $20 premium fee
            theMember = new Premium(name, method);
            System.out.println("Surprise! $20 Premium membership fee charged");
        } else { // if they choose not to be premium, add to members arraylist with no fee
            theMember = new Member(name, method);
        }

        System.out.println("Welcome " + theMember.getName()); //welcome new member using entered name

        //while loop to allow member to choose what they would like to do
        //using 6 switch statements
        int i = 1;
        while (i > 0) {
            //ask to choose between 1-6
            System.out.println("What would you like to do?");
            System.out.println("1. Purchase Book");
            System.out.println("2. Purchase CD");
            System.out.println("3. Return Book");
            System.out.println("4. Return CD");
            System.out.println("5. Donate Product");
            System.out.println("6. Leave");
            Scanner scann = new Scanner(System.in); //scans which num the member picks
            int ch = scann.nextInt(); //stores that num into 'ch' to use for the switch

            //switch to determine which function to proceed with
            switch (ch) {

                case 1:

                    store.printBooks(); //shows books available to purchase
                    System.out.println("Choose your Book"); //member chooses a # from the books array 
                    Scanner bookS = new Scanner(System.in); //scan chosen book, store into bookChoice as int
                    int bookChoice = bookS.nextInt();
                    Book book = store.books.get(bookChoice - 1); //find chosen book by subtracting 1 to get actual books arraylist index
                    theMember.purchaseBook(book); //give book to member using purchaseBook method
                    store.books.remove(book); //remove chosen book from books arraylist

                    System.out.println("Total spent is " + theMember.getTotalSpent());

                    break;

                case 2:

                    store.printCDs(); //shows cds available to purchase
                    System.out.println("Choose your CD"); //member chooses a # from the cds array 
                    Scanner cdS = new Scanner(System.in); //scan chosen cd, store into cdChoice as int
                    int cdChoice = cdS.nextInt();
                    CD cd = store.cds.get(cdChoice - 1); //find chosen cd by subtracting 1 to get actual cds arraylist index
                    theMember.purchaseCD(cd); //give cd to member using purchaseCD method
                    store.cds.remove(cd);//remove chosen cd from cds arraylist

                    System.out.println("Total spent is " + theMember.getTotalSpent()); //print amount the member has now spent in total

                    break;

                case 3:

                    System.out.println("Which book are you returning?");
                    theMember.printPurchasedBooks(); //print books available to return from booksPurchased arrraylist
                    Scanner bookR = new Scanner(System.in); //scan which book to return from provided list
                    int bookReturn = bookR.nextInt(); //store that book into an int variable bookReturn
                    Book bookR1 = store.books.get(bookReturn - 1); //find actual arraylist index of the book by -1
                    theMember.returnBook(bookR1); //remove book from array list and subract total spent
                    store.books.add(bookR1); //put back the returned book in books arraylist
                    System.out.println(theMember.getName() + " has returned " //display returned book, price, & new total spent
                            + bookR1.getTitle() + " for $" + bookR1.getPrice());
                    System.out.println("Total returned is " + theMember.getTotalSpent());

                    break;

                case 4:

                    System.out.println("Which cd are you returning?");
                    theMember.printPurchasedCDs(); //print cds available to return from cdsPurchased arrraylist
                    Scanner cdR = new Scanner(System.in); //scan which cd to return from provided list
                    int cdReturn = cdR.nextInt(); //store that cd into an int variable cdReturn
                    CD cdR1 = store.cds.get(cdReturn - 1); //find actual arraylist index of the cd by -1
                    theMember.returnCD(cdR1); //remove cd from array list and subract total spent
                    store.cds.add(cdR1); //put back the returned cd in cds arraylist
                    System.out.println(theMember.getName() + " has returned " //display returned cd, price, & new total spent
                            + cdR1.getTitle() + " for $" + cdR1.getPrice());
                    System.out.println("Total returned is " + theMember.getTotalSpent());

                    break;

                case 5:

                    store.donateProduct(); //allow member to donate product of choice
                    store.printDonatedProducts(); //display all donated products
                    break;

                case 6:
                    theMember.printPurchasedProducts(); //display all products purchased
                    theMember.printTotalSpent(); //display total spent
                    store.printDonatedProducts(); //display all donated products
                    System.out.println("Have a nice day!");
                    return;

                default:

            }
            System.out.println("\n");
            System.out.println("Would you like to do something else?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            Scanner keepGoing = new Scanner(System.in);
            int shopping = keepGoing.nextInt();
            if (shopping == 2) { //if user doesn't continue, all products purchased, total spent, & donated will be printed
                i = 0;
                System.out.println("\n");
                theMember.printPurchasedProducts();
                theMember.printTotalSpent();
                store.printDonatedProducts();
            } //if member continues, they will go back to line 49
        }
        System.out.println("\n");
        System.out.println("Have a nice day!"); //last line of code

    }
}
