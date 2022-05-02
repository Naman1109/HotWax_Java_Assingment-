package Core_Java_Assignments;

import java.io.*;

// Account class With initial Balance of 1000
class Account {

    int balance = 1000;

    void widraw(int bal) {
        this.balance = balance - bal;

    }

    public int getbal() {
        return balance;
    }
}

// Thread Decleration and exexution

public class Assignment_4 extends Thread {

    Account acc = new Account();

    public static void main(String[] args) {
        Assignment_4 Asign = new Assignment_4();
        Thread p1 = new Thread(Asign, "Person_1");
        Thread p2 = new Thread(Asign, "Person_2");
        p1.start();
        p2.start();

    }

    @Override
    public void run() {

        for (int i = 0; i < 2; i++) {
            widrawMoney(100);
//widrawMoney(500);
//widrawMoney(800);
        }
    }

    // To Make The Program Thread Safe I used synchronized method. 
    private synchronized void widrawMoney(int bal) {
        if (acc.getbal() >= bal) {
            System.out.println(Thread.currentThread().getName() + "Is Trying to widraw : " + bal);
            try {

                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            acc.widraw(bal);

            System.out.println(Thread.currentThread().getName() + " Is completed The widrawal of : " + bal);
            System.out.println("Avalible Balance :" + acc.getbal());
        } else {
            System.out.println("Account Does Not Have Enough Money To widraw.." + '\n' + "Please make Deposit..!");
        }

    }
}
