package Core_Java_Assignments;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.*;

class Employee implements Serializable {

    String Name;
    String Email_Address;
    String Age;
    String Date_Of_Birth;

    public Employee(String Name, String Email_Address, String Age, String Date_Of_Birth) {
        this.Name = Name;
        this.Email_Address = Email_Address;
        this.Age = Age;
        this.Date_Of_Birth = Date_Of_Birth;
    }

    public String toString() {
        return "name: " + Name + "Email: " + Email_Address + "Age: " + Age + "Date Of Birth: " + Date_Of_Birth;
    }

}

class Assignment_3_F {

    static FileOutputStream fout;

////////////////////////////////////////////...Add.../////////////////////////////

    void add(ArrayList<Employee> array_list) {

        Scanner sc1 = new Scanner(System.in);
        int n = sc1.nextInt();
        for (int i = 0; i <= n; i++) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Pkease Enter Name..!");
            String Name = sc.nextLine();
            System.out.println("Please Enter Email_Address..!");
            String Email_Address = sc.nextLine();
            System.out.println("Pkease Enter Age..!");
            String Age = sc.nextLine();
            System.out.println("please Enter Date_Of_Birth (dd/mm/yyyy)..!");
            String Date_Of_Birth = sc.nextLine();

            ObjectOutputStream oos = null;
            array_list.add(new Employee(Name, Email_Address, Age, Date_Of_Birth));

            try {
                File file = new File("employees.txt");
                fout = new FileOutputStream(file);
                oos = new ObjectOutputStream(fout);
                oos.writeObject(array_list);
                oos.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

////////////////////////////////////////////Display/////////////////////////////

    public void display(ArrayList<Employee> Employee1) {
        ListIterator litr = null;

        try {

            FileInputStream fileIn = new FileInputStream("employees.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Employee1 = (ArrayList<Employee>) objectIn.readObject();
            System.out.println("The Object has been read from the file");
            objectIn.close();

            litr = Employee1.listIterator();

            System.out.println("\n Employees Data");
            while (litr.hasNext()) {
                System.out.println(litr.next());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
////////////////////////////////////////////Search/////////////////////////////

    public void search() {
        ListIterator litr = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Name..!");
        String Name = sc.nextLine();

        try {

            FileInputStream fileIn = new FileInputStream("employees.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ArrayList<Employee> Employee1 = (ArrayList<Employee>) objectIn.readObject();
            System.out.println("The Object has been read from the file");
            objectIn.close();

            litr = Employee1.listIterator();

            System.out.println("\n Employees Data");
            while (litr.hasNext()) {
                Employee emp = (Employee) litr.next();
                if (emp.Name.equals(Name)) {
                    System.out.println(emp);
                } else {
                    System.out.println("Record Not Found..!");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }
    /////////////////////////////////Remove///////////////////////////

    public void remove() {
        ListIterator litr = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Name..!");
        String Name = sc.nextLine();

        try {

            FileInputStream fileIn = new FileInputStream("employees.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ArrayList<Employee> Employee1 = (ArrayList<Employee>) objectIn.readObject();
            System.out.println("The Object has been read from the file");
            objectIn.close();

            litr = Employee1.listIterator();

            System.out.println("\n Employees Data");
            while (litr.hasNext()) {
                Employee emp = (Employee) litr.next();
                if (emp.Name.equals(Name)) {
                    litr.remove();

                } else {
                    System.out.println("Record Not Found..!");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }
    ///////////////////////////////////////Sort/////////////////////////////

    public void sort1() {
        ListIterator litr = null;

        try {

            FileInputStream fileIn = new FileInputStream("employees.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            ArrayList<Employee> Employee1 = (ArrayList<Employee>) objectIn.readObject();
            System.out.println("The Object has been read from the file");
            objectIn.close();

            Collections.sort(Employee1, new Comparator<Employee>() {
                public int compare(Employee emp1, Employee emp2) {
                    return emp1.Name.compareTo(emp2.Name);
                }
            });

            litr = Employee1.listIterator();

            System.out.println("\n Employees Data");
            while (litr.hasNext()) {
                System.out.println(litr.next());

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    public static void main(String[] args) {

        Assignment_3_F f1 = new Assignment_3_F();
        Employee em = new Employee("shubham", "Email_Address", "Age", "Date_Of_Birth");
        ArrayList<Employee> array_list = new ArrayList<Employee>();

        System.out.println(" Enter Operation Choice...!");
        System.out.println("Menue..!");
        System.out.println("1. Display");
        System.out.println("2. Add");
        System.out.println("3. Delete");
        System.out.println("4. Search");
        System.out.println("5. Sort");

        System.out.println("Please Enter Choice...!");
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();

        switch (i) {

            case 1:

                f1.display(array_list);

                break;
            case 2:

                f1.add(array_list);

                break;

            case 3:
                f1.remove();

                break;

            case 4:

                f1.search();
                break;
            case 5:

                f1.sort1();
                break;

        }
    }

}
