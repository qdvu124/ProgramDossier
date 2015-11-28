/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package programdossier;

// Standard Level Mastery Aspect 14: Use of additional Library
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Vu Dinh Quan IDE: Netbeans IDE 7.2.1 School: Anglo-Chinese School
 * (Independent) Program Name: Pizza Shop Last modified: 8/4/2013 Operation
 * System: Windows 32 bit Purpose: A system to manage pizza shops
 */
/*
 * Standard Level Mastery Aspect 2: User-defined Objects
 * Standard Level Mastery Aspect 3: Object as data Records
 * Standard Level Mastery Aspect 4: Simple selection
 * Standard Level Mastery Aspect 5: Complex selection 
 * Standard Level Mastery Aspect 8: User-defined method
 * Standard Level Mastery Aspect 9: User-defined method with parameter
 * Standard Level Mastery Aspect 10: User-defined method with appropriate return values
 * Standard Level Mastery Aspect 14: Use of additional libraries
 * Higher Level Mastery Aspect 8: Encapsulation
 * Higher Level Mastery Aspect 10: Implementing a hierachical compostie data structure
 * Higher Level Mastery Aspect 12 -15: Implementation of an Abstract Data Structure
 */
public class Bill {
    // Higher Level Mastery Aspect 8: Encapsulation
    // Higher Level Mastery Aspect 10: Implementing a hierachical composite data structure

    int billNo;
    String CustomerName;
    int postalCode;
    int cChoice;
    int tChoice;
    int eChoice;
    double price;
    boolean status;
    boolean paid;
    Bill next;
    Bill previous;

    // Standard Level Mastery Aspect 2: User-defined Objects
    // Standard Level Mastery Aspect 3: Object as data Records
    // Higher Level Mastery Aspect 12 - 15: Implementation of an Abstract Data Structure
    // One aspect: Node style class with appropriate constructors with method to get and set data elements
    public Bill() {
        billNo = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                input.nextLine();
                System.out.print("Please enter the name of the customer: ");
                CustomerName = input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Data type is not of type string, an error has occured");
                System.out.println("Please type again: ");
                continue;
            }
        }

        while (true) {
            try {
                System.out.print("Please enter the postal code(Optional): ");
                postalCode = input.nextInt();

                if (postalCode < 0) {
                    System.out.println("Bad input.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Data type is not of type integer, an error has occured");
                System.out.println("Please type again: ");
                input.nextLine();
                continue;
            }
        }

        while (true) {
            try {
                System.out.print("Please enter the crust choice: ");
                cChoice = input.nextInt();
                if (cChoice < 1 || cChoice > 3) {
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

        while (true) {
            try {
                System.out.print("Please enter the topping choice: ");
                tChoice = input.nextInt();
                if (tChoice < 1 || tChoice > 3) {
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

        while (true) {
            try {
                System.out.print("Please enter the extra choice: ");
                eChoice = input.nextInt();
                if (eChoice < 1 || eChoice > 3) {
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
        setPrice();
        status = false;
        paid = false;
    }

    // Higher Level Mastery Aspect 12 - 15: Implementation of an Abstract Data Structure
    // One aspect: Node style class with appropriate constructors with method to get and set data elements
    public Bill(String readLine) {
        Scanner input = new Scanner(readLine).useDelimiter("/");
        billNo = input.nextInt();
        CustomerName = input.next();
        postalCode = input.nextInt();
        cChoice = input.nextInt();
        tChoice = input.nextInt();
        eChoice = input.nextInt();
        price = input.nextDouble();
        status = input.next().equals("Done");
        paid = input.next().equals("Paid");
    }

    // Standard Level Mastery Aspect 8: User-defined method
    // Standard Level Mastery Aspect 9: User-defined method with parameter
    // Higher Level Mastery Aspect 12 - 15: Implementation of an Abstract Data Structure
    // One aspect: Node style class with appropriate constructors with method to get and set data elements
    public void setName(String name) {
        CustomerName = name;
    }

    public void setPostalCode(int code) {
        postalCode = code;
    }

    public void setCC(int cC) {
        cChoice = cC;
    }

    public void setTC(int tC) {
        tChoice = tC;
    }

    public void setEC(int eC) {
        eChoice = eC;
    }

    // Standard Level Mastery Aspect: Complex selection
    private void setPrice() {
        double price1 = 0;
        double price2 = 0;
        double price3 = 0;
        try {
            switch (cChoice) {
                case 1:
                    price1 = 1.0;
                    break;
                case 2:
                    price1 = 1.0;
                    break;
                case 3:
                    price1 = 1.0;
                    break;
                default:
                    price1 = 0;
            }
            switch (tChoice) {
                case 1:
                    price2 = 14.0;
                    break;
                case 2:
                    price2 = 15.0;
                    break;
                case 3:
                    price2 = 14.5;
                    break;
                case 4:
                    price2 = 15.0;
                    break;
                case 5:
                    price2 = 15.0;
                    break;
                default:
                    price2 = 0;
                    break;
            }
            switch (eChoice) {
                case 1:
                    price3 = 2.0;
                    break;
                case 2:
                    price3 = 1.5;
                    break;
                case 3:
                    price3 = 1.5;
                    break;
                default:
                    price3 = 0;
                    break;
            }
            price = price1 + price2 + price3;
        } catch (NullPointerException e) {
            price = 0;
        }
    }

    // Standard Level Mastery Aspect 10: User-defined method with appropriate return values
    // Higher Level Mastery Aspect 12 - 15: Implementation of an Abstract Data Structure
    // One aspect: Node style class with appropriate constructors with method to get and set data elements
    public int getNo() {
        try {
            return billNo;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public String getName() {
        try {
            return CustomerName;
        } catch (NullPointerException e) {
            return "";
        }
    }

    public int getPostalCode() {
        try {
            return postalCode;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public int getCC() {
        try {
            return cChoice;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public int getTC() {
        try {
            return tChoice;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public int getEC() {
        try {
            return eChoice;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public double getPrice() {
        try {
            return price;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public String getStatus() {
        try {
            if (status) {
                return "Done";
            } else {
                return "Not done";
            }
        } catch (NullPointerException e) {
            return "Error";
        }
    }

    // Standard Level Mastery Aspect 4: Simple selection
    public String getPaid() {
        try {
            if (paid) {
                return "Paid";
            } else {
                return "Not paid";
            }
        } catch (NullPointerException e) {
            return "Error";
        }
    }

    public void changeSts() {
        if (status == true) {
            status = false;
        } else {
            status = true;
        }
    }

    public void changePaid() {
        if (paid == true) {
            paid = false;
        } else {
            paid = true;
        }
    }

    public void display() {
        String dataStream;
        dataStream = getNo() + "/" + getName() + "/" + getPostalCode() + "/" + getCC() + "/" + getTC() + "/" + getEC()
                + "/" + getPrice() + "/" + getStatus() + "/" + getPaid();
        System.out.println(dataStream);
    }
}
