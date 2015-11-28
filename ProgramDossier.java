/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package programdossier;

import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vu Dinh Quan IDE: Netbeans IDE 7.2.1 School: Anglo-Chinese School
 * (Independent) Program Name: Pizza Shop Last modified: 8/4/2013 Operation
 * System: Windows 32 bit Purpose: A system to manage pizza shops
 */
/* Standard Level Mastery Aspects Achieved:
 * Aspect 1: Arrays
 * Aspect 2: User-defined objects
 * Aspect 3: Objects as data records
 * Aspect 4: Simple selection If-Else
 * Aspect 5: Complex selection (switch)
 * Aspect 6: Loops
 * Aspect 7: Nested loops
 * Aspect 8: User-defined methods
 * Aspect 9: User-defined methods with parameters
 * Aspect 10: User-defined methods with appropriate return values
 * Aspect 11: Sorting
 * Aspect 12: Searching
 * Aspect 13: File i/o
 * Aspect 14: Use of additional libraries
 * Aspect 15: Use of sentinels and flags
 * Higher Level Mastery Aspects Achieved:
 * Aspect 1: Adding data to an instance of the RandomAccessFile class by direct manipulation of the pointer uisng the seek method
 * Aspect 2: Deleting data from an instance of the RandomAccessFIle class by direct maniuplation of the pointer using the seek method
 * Aspect 4: Recursion
 * Aspect 6: Polymorphism
 * Aspect 7: Inheritance
 * Apsect 8: Encapsulation
 * Aspect 9: Parsing a text or other data stream
 * Aspect 10: Implementing a hierachical composite data structure. A composite data structure in this definition is a class
 *   implementing a record style data structure. A hierachical composite data structure is one that contains more than one element
 *   and at least one of the elements is a composite data structure. Examples are, an array or linked list of records, a record that
 *   has one field that is another record, or an array
 * Aspect 11: The use of any five Standard Level Mastery factors - This can only be applied once
 * Aspect 12: A node style class with appropriate constructors and methods to set and get data elements
 * Aspect 13: Methods are implemented to add at/ remove from the head and the tail of the list
 * Aspect 14: Proper checks are made for errors such as attempting to get an element from an empty list or inserting the same element tiwce
 * Aspect 15: All error conditions are checked for, and all appropriate methods are implemented
 * Aspect 16: Use of external libraries
 */
public class ProgramDossier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        PizzaShop Shop = new PizzaShop();
        Shop.List.displayForwards();
        //Login log = new Login();
        //log.setVisible(true);
        //log.setSize(500, 500);
        //log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Shop.test();
    }
}
