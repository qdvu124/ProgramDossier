/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package programdossier;

/**
 *
 * @author Vu Dinh Quan IDE: Netbeans IDE 7.2.1 School: Anglo-Chinese School
 * (Independent) Program Name: Pizza Shop Last modified: 8/4/2013 Operation
 * System: Windows 32 bit Purpose: A system to manage pizza shops
 */
/*
 * Standard Level Mastery Aspect 1: Arrays
 * Standard Level Mastery Aspect 7: Nested Loops
 * Standard Level Mastery Aspect 11: Sorting
 * Higher Level Mastery Aspect 4: Recursion
 * Higher Level Mastery Aspect 7: Inheritance
 */
// Higher Level Mastery Aspect 7: Inheritance
public class SortableList extends BillList {
    // Standard Level Mastery Aspect 1: Arrays

    Bill a[];
    int size;

    public void parseArray() {
        size = this.countSize();
        this.a = new Bill[size];
        Bill current = this.head;
        for (int i = 0; i < a.length; i++) {
            a[i] = current;
            if (current.next != null) {
                current = current.next;
            }
        }
    }

    public int partition(int l, int r) {
        int i = l;
        int j = r - 1;
        Bill tmp;
        int pivot = a[r].billNo;

        // Standard Level Mastery Aspect 7: Nested Loops
        while (true) {
            while (a[i].billNo < pivot) {
                i++;
            }
            while (a[j].billNo > pivot && j > 0) {
                j--;
            }
            if (i >= j) {
                break;
            } else {
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
                j--;
            }
        }
        tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }

    // Standard Level Mastery Aspect 10: Sorting
    // Higher Level Mastery Aspect 4: Recursion
    public void Quicksort(int l, int r) {

        if (l >= r) {
            return;
        } else {
            int part = partition(l, r);
            Quicksort(l, part - 1);
            Quicksort(part + 1, r);
        }
    }

    public void reOrder() {
        for (int i = 0; i < a.length; i++) {
            this.deleteTail();
        }
        System.out.println("The sorted data records are: ");
        for (int i = 0; i < a.length; i++) {
            this.insertTail(a[i]);
        }
    }

    public void changeStatus(Bill x) {
        if (x.status) {
            x.status = false;
        } else {
            x.status = true;
        }
    }

    public void changePaid(Bill x) {
        if (x.paid) {
            x.paid = false;
        } else {
            x.paid = true;
        }
    }
}
