
import java.util.*;
import java.io.*;

public class Assignment_5_Demo {

    static FileOutputStream fout;

    public static void main(String[] args) throws Exception {

        ArrayList<Object> student1 = new ArrayList<Object>();
        Student s1 = new Student("Naman", "naman123@gmail.com", "sanawad", "2001", "Sanawad", "M.P", "451111", "India");
        Student s2 = new Student("Subham", "shubham123@gmail.com", "Indore", "2002", "Rau", " M.P", "452003", "India");
        student1.add(s1);
        student1.add(s2);

        ObjectOutputStream oos = null;
        try {

            File file = new File("student1.txt");
            fout = new FileOutputStream(file);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(student1);
            oos.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        DeserializationTest d1 = new DeserializationTest();
        d1.Deserialization();
    }

}

class Student implements Serializable {

    private static final long serialVersionUID = 6206720214880624329l;
    String Name;
    String Email_Address;
    String Address_;
    String DOB;
    Address Address1;

    public Student(String Name, String Email_Address, String Address_, String DOB, String city, String State, String pinCode, String country) {
        this.Name = Name;
        this.Email_Address = Email_Address;
        this.Address_ = Address_;
        this.DOB = DOB;
        this.Address1 = new Address(city, State, pinCode, country);
    }

    public String toString() {
        return "name: " + Name + "Email: " + Email_Address + "Address: " + Address_ + "Date Of Birth: " + DOB;

    }

    class Address implements Serializable {

        String city;
        String State;
        String pinCode;
        String country;

        public Address(String city, String State, String pinCode, String country) {
            this.city = city;
            this.State = State;
            this.pinCode = pinCode;
            this.country = country;
        }

        public String toString() {
            return "city: " + city + "State: " + State + "pinCode: " + pinCode + "country: " + country;
        }

    }

    class DeserializationTest {

        void Deserialization() throws Exception {

            ListIterator litr = null;

            try {

                FileInputStream fileIn = new FileInputStream("student1.txt");
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);

                ArrayList<Object> student1 = (ArrayList<Object>) objectIn.readObject();
                System.out.println("The Object has been read from the file");
                objectIn.close();

                litr = student1.listIterator();

                System.out.println("\n Student Data");
                while (litr.hasNext()) {
                    System.out.println(litr.next());
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
