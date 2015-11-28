/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package programdossier;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Vu Dinh Quan IDE: Netbeans IDE 7.2.1 School: Anglo-Chinese School
 * (Independent) Program Name: Pizza Shop Last modified: 8/4/2013 Operation
 * System: Windows 32 bit Purpose: A system to manage pizza shops
 */
/*
 * Standard Level Mastery Aspect 6: Loops
 * Standard Level Mastery Aspect 13: File i/o
 * Standard Level Mastery Aspect 15: Use of sentinels or flags
 * Higher Level Mastery Aspect 1: Adding data to an instance of the RandomAccessFile class by direct manipulation of the pointer 
 *                  using the seek method
 * Higher Level Master Aspect 2: Deleting data from an instance of the RandomAccessFile class by direct manipulation of the pointer
 *                  using the seek method
 * Higher Level Mastery Aspect 9: Parsing a text file or other data stream
 * Higher Level Mastery Aspect 16: Use of additional libraries
 */
// Higher Level Mastery Aspect 9: Parsing a text file or other data stream
public final class PizzaShop {

    RandomAccessFile data = new RandomAccessFile("D://Data0.txt", "rw");
    SortableList List = new SortableList();

    public PizzaShop() throws IOException {
        load();
        System.out.println("The current size of data is " + List.countSize() + "\n");
    }

    public void test() throws IOException {
        Scanner input = new Scanner(System.in);
        String ask = "0. Exit\n1. Insert Head\n2. Remove Head\n3. Insert Tail\n4. Remove Tail\n5. Search\n6. Sort"
                + "\n7. Display Forwards\n\nYour choice: ";
        System.out.print(ask);
        int choice;
        while (true) {
            try {
                choice = input.nextInt();
                if (choice < 0 || choice > 7) {
                    System.out.println("Bad input.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Data type is not of type int, an error has occured");
                System.out.println("Please type again: ");
                input.nextLine();
                continue;
            }
        }
        System.out.println();
        Bill x;
        // Standard Level Mastery Aspect 5: Complex Selection (Switch)
        // Standard Level Mastery Aspect 6: Loops
        // Standard Level Mastery Aspect 15: Use of sentinels or flagss
        while (choice != 0) {
            switch (choice) {
                case 1:
                    x = new Bill();
                    List.insertHead(x);
                    if (x == x.next) {
                        System.out.println("Duplication!");
                        List.deleteHead();
                    } else {
                        addFileHead();
                    }
                    break;
                case 2:
                    System.out.println("Are you sure you want to delete the Bill?");
                    int delChoiceHead;
                    while (true) {
                        try {
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            delChoiceHead = input.nextInt();

                            if (delChoiceHead < 1 || delChoiceHead > 2) {
                                System.out.println("Bad input.");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Data type is not of type int, an error has occured");
                            System.out.println("Please type again: ");
                            input.nextLine();
                            continue;
                        }
                    }

                    if (delChoiceHead == 1) {
                        List.deleteHead();
                        updateFile();
                        break;
                    } else {
                        break;
                    }
                case 3:
                    x = new Bill();
                    List.insertTail(x);
                    if (x == x.previous) {
                        System.out.println("Duplication!");
                        List.deleteTail();
                    } else {
                        addFileTail(x);
                    }
                    break;
                case 4:
                    System.out.println("Are you sure you want to delete the Bill?");
                    int delChoiceTail;
                    while (true) {
                        try {
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            delChoiceTail = input.nextInt();

                            if (delChoiceTail < 1 || delChoiceTail > 2) {
                                System.out.println("Bad input.");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Data type is not of type int, an error has occured");
                            System.out.println("Please type again: ");
                            input.nextLine();
                            continue;
                        }
                    }

                    if (delChoiceTail == 1) {
                        List.deleteTail();
                        updateFile();
                        break;
                    } else {
                        break;
                    }
                case 5:
                    input.nextLine();
                    int searchChoice;
                    while (true) {
                        try {
                            System.out.println("Please enter choice for search. 1 for number, 2 for customer's name");
                            searchChoice = input.nextInt();

                            if (searchChoice < 1 || searchChoice > 2) {
                                System.out.println("Bad input.");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Data type is not of type int, an error has occured");
                            System.out.println("Please type again: ");
                            input.nextLine();
                            continue;
                        }
                    }
                    if (searchChoice == 1) {
                        System.out.print("Enter Bill's number: ");
                        int searchKey = input.nextInt();
                        List.search(searchKey);
                        updateFile();
                        break;
                    } else {
                        input.nextLine();
                        System.out.print("Enter the customer's name: ");
                        String searchKey = input.nextLine();
                        List.search(searchKey);
                        updateFile();
                        break;
                    }
                case 6:
                    List.parseArray();
                    List.Quicksort(0, List.size - 1);
                    List.reOrder();
                    updateFile();
                case 7:
                    List.displayForwards();
                default:
                    break;
            }
            System.out.println();
            System.out.print(ask);
            choice = input.nextInt();
        }
        System.exit(0);
    }

    public void load() throws IOException {
        long pos = 0;
        while (data.readLine() != null) {
            data.seek(pos);
            Bill temp = new Bill(data.readLine());
            pos = (long) data.getFilePointer();
            List.insertTail(temp);
        }
        System.out.printf("Load file done\n");
    }

    // Higher Level Mastery Aspect 1: Adding data to an instance of the RandomAccessFile class by direct manipulation of the pointer
    // using the seek method
    public void addFile(Bill a, Bill b, boolean after) throws IOException {
        boolean sent = true;
        long pos = 0;
        data.seek(pos);
        String strA = a.getNo() + "/" + a.getPostalCode() + "/"
                + a.getName() + "/" + a.getCC() + "/" + a.getTC() + "/"
                + a.getEC() + "/" + a.getPrice() + "/" + a.getStatus() + "/" + a.getPaid() + "/\r\n";
        String strB = b.getNo() + "/" + b.getPostalCode() + "/"
                + b.getName() + "/" + b.getCC() + "/" + b.getTC() + "/"
                + b.getEC() + "/" + b.getPrice() + "/" + b.getStatus() + "/" + b.getPaid() + "/\r\n";
        while (data.readLine() != null && sent) {
            data.seek(pos);
            if (data.readLine().equals(strA)) {
                if (after) {
                    pos = data.getFilePointer();
                } else {
                    data.seek(pos);
                }
                byte[] temp = new byte[(int) data.length() - (int) data.getFilePointer()];
                data.read(temp);
                data.seek(pos);
                data.write(strB.getBytes());
                data.write(temp);
                data.setLength(data.getFilePointer());
                System.out.println("Bill added to file");
                sent = false;
                return;
            } else {
                pos = data.getFilePointer();
            }
        }
        if (!sent) {
            System.out.println("Bill is found!");
            //JOptionPane.showMessageDialog(null, "Insertion position is not found","Insertion failed",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void addFileHead() throws IOException {
        data.setLength(0);
        data.seek(0);
        Bill current = List.head;
        while (current != null) {
            data.seek(data.getFilePointer());
            String dataIn = current.getNo() + "/" + current.getName() + "/" + current.getPostalCode() + "/"
                    + current.getCC() + "/" + current.getTC() + "/"
                    + current.getEC() + "/" + current.getPrice() + "/" + current.getStatus() + "/" + current.getPaid() + "/\r\n";
            byte[] temp = new byte[(int) data.length()];
            data.read(temp);
            data.write(dataIn.getBytes());
            current = current.next;
        }
    }

    public void addFileTail(Bill x) throws IOException {
        String dataIn = x.getNo() + "/" + x.getName() + "/"
                + x.getPostalCode() + "/" + x.getCC() + "/" + x.getTC() + "/"
                + x.getEC() + "/" + x.getPrice() + "/" + x.getStatus() + "/" + x.getPaid() + "/\r\n";
        while (data.readLine() != null) {
            data.readLine();
        }
        data.seek(data.getFilePointer());
        data.write(dataIn.getBytes());
        data.setLength(data.getFilePointer());
    }

    // Higher Level Mastery Aspect 2: Delete data from an instance of the RandomAccessFile class by direct manipulation of the pointer
    // using the seek method
    public void deleteFile(Bill x) throws IOException {//changename
        long pos = 0;
        data.seek(pos);
        String delete = x.getNo() + "/" + x.getName() + "/"
                + x.getPostalCode() + "/" + x.getCC() + "/" + x.getTC() + "/"
                + x.getEC() + "/" + x.getPrice() + "/" + x.getStatus() + "/" + x.getPaid() + "/";
        while (data.readLine() != null) {
            data.seek(pos);
            if (data.readLine().equals(delete)) {
                byte[] temp = new byte[(int) data.length() - (int) data.getFilePointer()];
                data.read(temp);
                data.seek(pos);
                data.write(temp);
                data.setLength(data.getFilePointer());
                //JOptionPane.showMessageDialog(null, "Bill is deleted from file.","Deletion", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                pos = data.getFilePointer();
            }
        }
        System.out.println("Not found!");
        //JOptionPane.showMessageDialog(null, "Bill is not found in file", "Deletion failed", JOptionPane.INFORMATION_MESSAGE);
    }

    public void updateFile() throws IOException {
        long pos = 0;
        Bill current = List.head;
        while (current != null) {
            data.seek(pos);
            String input = current.getNo() + "/" + current.getName() + "/"
                    + current.getPostalCode() + "/" + current.getCC() + "/" + current.getTC() + "/"
                    + current.getEC() + "/" + current.getPrice() + "/" + current.getStatus() + "/" + current.getPaid() + "/\r\n";
            data.write(input.getBytes());
            pos = data.getFilePointer();
            current = current.next;
        }
        data.setLength(pos);
    }
}
