/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package programdossier;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Vu Dinh Quan IDE: Netbeans IDE 7.2.1 School: Anglo-Chinese School
 * (Independent) Program Name: Pizza Shop Last modified: 8/4/2013 Operation
 * System: Windows 32 bit Purpose: A system to manage pizza shops
 */
/*
 * Higher Level Mastery Aspect 6: Polymorphism
 * Higher Level Mastery Aspect 12 -15: Implementation of an Abstract Data Structure
 */
public class BillList {

    Scanner input = new Scanner(System.in);
    Bill head;
    Bill tail;

    public BillList() {
        head = null;
        tail = null;
    }

    // Higher Level Mastery Aspect 12 - 15: Implementation of an Abstract Data Structure
    // Two aspects: Methods are implemented to add at/remove from the tail and the head of the list
    public void insertHead(Bill a) {
        if (isEmpty()) {
            tail = a;
        } else {
            head.previous = a;
        }
        if (a.billNo == 0) {
            a.billNo = maxBillNo() + 1;
        }
        a.next = head;
        head = a;
    }

    // Higher Level Mastery Aspect 12 - 15: Implementation of an Abstract Data Structure
    // Two aspects: Methods are implemented to add at/remove from the tail and the head of the list 
    public void insertTail(Bill a) {
        if (isEmpty()) {
            head = a;
        } else {
            tail.next = a;
            a.previous = tail;
        }
        if (a.billNo == 0) {
            a.billNo = maxBillNo() + 1;
        }
        tail = a;
    }

    // Higher Level Mastery Aspect 12 - 15: Implementation of an Abstract Data Structure
    // Two aspects: Methods are implemented to add at/remove from the tail and the head of the list
    // Three aspects: Proper checks are made for errors such as attempting to get an element from an empty list or inserting
    // the same element twice
    public void deleteHead() {
        if (isEmpty()) {
            System.out.print("Error. Underflow!");
        } else if (head.next == null) {
            head.display();
            System.out.print("Preparing to delete the first bill...\n");
            tail = null;
            head = head.next;
            System.out.print("Deletion successful!\n");
            System.out.println();
        } else {
            head.display();
            System.out.print("Preparing to delete the first bill...\n");
            head.next.previous = null;
            head = head.next;
            System.out.print("Deletion successful!\n");
            System.out.print("The first bill is now: \n");
            head.display();
            System.out.println();
        }
    }

    // Higher Level Mastery Aspect 12 - 15: Implementation of an Abstract Data Structure
    // Two aspects: Methods are implemented to add at/remove from the tail and the head of the list
    public void deleteTail() {
        if (isEmpty()) {
            System.out.print("Error. Underflow!\n");
        } else if (tail.previous == null) {
            tail.display();
            System.out.print("Preparing to delete the last bill...\n");
            head = null;
            tail = tail.previous;
            System.out.print("Deletion successful!\n");
            System.out.println();
        } else {
            tail.display();
            System.out.print("Preparing to delete the last bill...\n");
            tail.previous.next = null;
            tail = tail.previous;
            System.out.print("Deletion successful!\n");
            System.out.print("The last bill is now: \n");
            tail.display();
            System.out.println();
        }
    }

    // Higher Level Mastery Aspect 12 - 15: Implementation of an Abstract Data Structure
    // Four aspects: All errors conditions are checked for, and all appropriate methods are implemented
    public void insertBefore(int key, Bill a) {
        Bill current = tail;
        while (current.billNo != key) {
            current = current.previous;
            if (current == null) {
                System.out.print("Cannot find the insertion position\n");
                return;
            } else if (current == head) {
                a.previous = null;
                head = a;
            } else {
                a.previous = current.previous;
                current.previous.next = a;
            }
            current.previous = a;
            a.next = current;
        }
    }

    public void insertAfter(int key, Bill a) {
        Bill current = head;
        while (current.billNo != key) {
            current = current.next;
            if (current == null) {
                System.out.print("Cannot find the insertion position\n");
                return;
            }
        }
        if (current == tail) {
            a.next = null;
            tail = a;
        } else {
            a.next = current.next;
            current.next.previous = a;
        }
        current.next = a;
        a.previous = current;
    }

    public void deleteBefore(int key) {
        Bill current = tail;
        while (current.billNo != key) {
            current = current.previous;
            if (current == null) {
                System.out.print("Cannot find the bill to delete\n");
                return;
            }
        }
        if (current == head) {
            head = current.next;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
    }

    public void deleteAfter(int key) {
        Bill current = head;
        while (current.billNo != key) {
            current = current.next;
            if (current == null) {
                System.out.print("Cannot find the bill to delete\n");
                return;
            }
        }
        if (current == tail) {
            tail = current.previous;
        } else {
            current.next.previous = current.previous;
            current.previous.next = current.next;
        }
    }

    // Higher Level Mastery Aspect 12 - 15: Implementation of an Abstract Data Structure
    // Three aspects: Proper checks are made for errors such as attempting to get an element from an empty list or inserting
    // the same element twice
    public void delete(int key) {
        Bill current = head;
        while (current.billNo != key) {
            current = current.next;
            if (current == null) {
                System.out.print("Cannot find the bill to delete\n");
                return;
            }
        }
        if (current == head) {
            head = head.next;
        } else {
            current.previous.next = current.next;
        }
        if (current == tail) {
            tail = tail.previous;
        } else {
            current.next.previous = current.previous;
        }
    }

    public void search(int key) {
        Bill current = head;
        int modChoice;
        while (current != null) {
            if (current.billNo == key) {
                current.display();
                System.out.println("Do you want to modify the bill?");
                while (true) {
                    try {
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        System.out.println("3. Delete");
                        modChoice = input.nextInt();

                        if (modChoice < 1 || modChoice > 3) {
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

                if (modChoice == 1) {
                    int furtherChoice;
                    System.out.println("Please select the data member you want to change: ");
                    while (true) {
                        try {
                            System.out.println("1. Name");
                            System.out.println("2. Postal Code");
                            System.out.println("3. Crust Choice");
                            System.out.println("4. Topping Choice");
                            System.out.println("5. Extra Choice");
                            System.out.println("6. Status");
                            System.out.println("7. Paid");
                            furtherChoice = input.nextInt();

                            if (furtherChoice < 1 || furtherChoice > 7) {
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

                    switch (furtherChoice) {
                        case 1:
                            System.out.println("Please enter the customer's name");
                            String newName;
                            input.nextLine();
                            while (true) {
                                try {
                                    newName = input.nextLine();
                                    current.setName(newName);
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Input mismatch!");
                                    System.out.println("Please type again: ");
                                    input.nextLine();
                                    continue;
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Please enter the postal code");
                            int newPost;
                            while (true) {
                                try {
                                    newPost = input.nextInt();
                                    current.setPostalCode(newPost);
                                    if (newPost < 0) {
                                        System.out.println("Bad input.");
                                    } else {
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Input mismatch!");
                                    System.out.println("Please type again: ");
                                    input.nextLine();
                                    continue;
                                }
                            }
                            break;
                        case 3:
                            int newCC;
                            while (true && !current.paid && !current.status) {
                                try {
                                    System.out.println("Please enter the crust choice ");
                                    newCC = input.nextInt();
                                    current.setCC(newCC);
                                    if (newCC < 1 || newCC > 3) {
                                        System.out.println("Bad input.");
                                    } else {
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Input mismatch!");
                                    System.out.println("Pleaes type again: ");
                                    input.nextLine();
                                    continue;
                                }
                            }
                            if (current.paid || current.status) {
                                System.out.println("The pizza has been baked or paid for!");
                            }
                            break;
                        case 4:
                            int newTC;
                            while (true && !current.paid && !current.status) {
                                try {
                                    System.out.println("Please enter the topping choice ");
                                    newTC = input.nextInt();
                                    current.setTC(newTC);
                                    if (newTC < 1 || newTC > 3) {
                                        System.out.println("Bad input.");
                                    } else {
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Input mismatch!");
                                    System.out.println("Pleaes type again: ");
                                    input.nextLine();
                                    continue;
                                }
                            }
                            if (current.paid || current.status) {
                                System.out.println("The pizza has been baked or paid for!");
                            }
                            break;
                        case 5:
                            int newEC;
                            while (true && !current.paid && !current.status) {
                                try {
                                    System.out.println("Please enter the extra choice ");
                                    newEC = input.nextInt();
                                    current.setEC(newEC);
                                    if (newEC < 1 || newEC > 3) {
                                        System.out.println("Bad input.");
                                    } else {
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Input mismatch!");
                                    System.out.println("Pleaes type again: ");
                                    input.nextLine();
                                    continue;
                                }
                            }
                            if (current.paid || current.status) {
                                System.out.println("The pizza has been baked or paid for!");
                            }
                            break;
                        case 6:
                            current.changeSts();
                            break;
                        case 7:
                            current.changePaid();
                            break;
                    }
                } else if (modChoice == 3) {
                    System.out.println("Are you sure you want to delete the Bill?");
                    int delChoice;
                    while (true) {
                        try {
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            delChoice = input.nextInt();

                            if (delChoice < 1 || delChoice > 2) {
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

                    if (delChoice == 1) {
                        delete(current.billNo);
                        break;
                    }
                }
            }
            current = current.next;
        }
    }

    //Standard Level Mastery Aspect 12: Searching
    // Higher Level Mastery Aspect 6: Polymorphism
    public void search(String userName) {
        int modChoice;
        Bill current = head;
        while (current != null) {
            if (current.CustomerName.contains(userName)) {
                current.display();
                System.out.println("Do you want to modify the bill?");
                while (true) {
                    try {
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        System.out.println("3. Delete");
                        modChoice = input.nextInt();

                        if (modChoice < 1 || modChoice > 3) {
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

                if (modChoice == 1) {
                    int furtherChoice;
                    System.out.println("Please select the data member you want to change: ");
                    while (true) {
                        try {
                            System.out.println("1. Name");
                            System.out.println("2. Postal Code");
                            System.out.println("3. Crust Choice");
                            System.out.println("4. Topping Choice");
                            System.out.println("5. Extra Choice");
                            System.out.println("6. Status");
                            System.out.println("7. Paid");
                            furtherChoice = input.nextInt();

                            if (furtherChoice < 1 || furtherChoice > 7) {
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
                    switch (furtherChoice) {
                        case 1:
                            input.nextLine();
                            System.out.println("Please enter the customer's name");
                            String newName;
                            while (true) {
                                try {
                                    newName = input.nextLine();
                                    current.setName(newName);
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Input mismatch!");
                                    System.out.println("Please type again: ");
                                    input.nextLine();
                                    continue;
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Please enter the postal code ");
                            int newPost;
                            while (true) {
                                try {
                                    newPost = input.nextInt();
                                    current.setPostalCode(newPost);
                                    if (newPost < 0) {
                                        System.out.println("Bad input.");
                                    } else {
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Input mismatch!");
                                    System.out.println("Please type again: ");
                                    input.nextLine();
                                    continue;
                                }
                            }
                            break;
                        case 3:
                            int newCC;
                            while (true && (!current.paid && current.status)) {
                                try {
                                    System.out.println("Please enter the crust choice ");
                                    newCC = input.nextInt();
                                    current.setCC(newCC);
                                    if (newCC < 1 || newCC > 3) {
                                        System.out.println("Bad input.");
                                    } else {
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Input mismatch!");
                                    System.out.println("Pleaes type again: ");
                                    input.nextLine();
                                    continue;
                                }
                            }
                            if (current.paid || current.status) {
                                System.out.println("The pizza has been baked or paid for!");
                            }
                            break;
                        case 4:
                            int newTC;
                            while (true && !current.paid && !current.status) {
                                try {
                                    System.out.println("Please enter the topping choice ");
                                    newTC = input.nextInt();
                                    current.setTC(newTC);
                                    if (newTC < 1 || newTC > 3) {
                                        System.out.println("Bad input.");
                                    } else {
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Input mismatch!");
                                    System.out.println("Please type again: ");
                                    input.nextLine();
                                    continue;
                                }
                            }
                            if (current.paid || current.status) {
                                System.out.println("The pizza has been baked or paid for!");
                            }
                            break;
                        case 5:
                            int newEC;
                            while (true && !current.paid && !current.status) {
                                try {
                                    System.out.println("Please enter the extra choice ");
                                    newEC = input.nextInt();
                                    current.setEC(newEC);
                                    if (newEC < 1 || newEC > 3) {
                                        System.out.println("Bad input.");
                                    } else {
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Input mismatch!");
                                    System.out.println("Pleaes type again: ");
                                    input.nextLine();
                                    continue;
                                }
                            }
                            if (current.paid || current.status) {
                                System.out.println("The pizza has been baked or paid for!");
                            }
                            break;
                        case 6:
                            current.changeSts();
                            break;
                        case 7:
                            current.changePaid();
                            break;
                    }
                } else if (modChoice == 3) {
                    System.out.println("Are you sure you want to delete the Bill?");
                    int delChoice;
                    while (true) {
                        try {
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            delChoice = input.nextInt();

                            if (delChoice < 1 || delChoice > 2) {
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

                    if (delChoice == 1) {
                        delete(current.billNo);
                        break;
                    }
                }
            }
            current = current.next;
        }
    }

    public int countSize() {
        int size = 0;
        if (isEmpty()) {
            return size;
        } else {
            Bill current = head;
            while (current != null) {
                size++;
                current = current.next;
            }
            return size;
        }
    }

    public void displayForwards() {
        Bill current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackwards() {
        Bill current = tail;
        while (current != null) {
            current.display();
            current = current.previous;
        }
        System.out.println();
    }

    public void displayHead() {
        head.display();
    }

    public void displayTail() {
        tail.display();
    }

    public int maxBillNo() {
        int max = 0;
        Bill current = head;
        while (current != null) {
            if (max < current.billNo) {
                max = current.billNo;
            }
            current = current.next;
        }
        return max;
    }

    public boolean isEmpty() {
        return (head == null);
    }
}
