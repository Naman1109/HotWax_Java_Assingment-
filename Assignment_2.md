package Core_Java_Assignments;

import java.util.Scanner;

class calculator {

    void circle() {
        System.out.println("Please Enter Radious");
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();

        System.out.println("Area Of circle is :" + 3.14 * (r * r));
        System.out.println("Perimeter Of Ciecle is :" + 2 * 3.14 * r);

    }

    void square() {

        System.out.println("Please Enter Length");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Area Of Square is :" + a * a);
        System.out.println("Perimeter Of Square is :" + 4 * a);
    }

    void traingle() {

        System.out.println("Please Enter Hight");
        Scanner sc = new Scanner(System.in);
        int th = sc.nextInt();
        System.out.println("Please Enter Base");
        int tb = sc.nextInt();
        System.out.println("Area Of Tringle is :" + 12 * tb * th);
        System.out.println("Perimeter Of Tringle is :" + 12 * tb * th);
    }

    void cylinder() {
        System.out.println("Please Enter Radious");
        Scanner sc = new Scanner(System.in);

        int cr = sc.nextInt();
        System.out.println("Please Enter Hight");
        int ch = sc.nextInt();

        System.out.println("Volume Of cylinder is :" + 3.14 * (cr * cr) * ch);
        System.out.println("Susface Area Of cylinder is :" + 2 * 3.14 * cr * ch);
        System.out.println("Area Of cylinder is :" + 2 * 3.14 * cr * (ch + cr));

    }

    void rectangle() {
        System.out.println("Please Enter Length");
        Scanner sc = new Scanner(System.in);

        int rec = sc.nextInt();
        System.out.println("Please Enter Breadth");
        int recb = sc.nextInt();
        System.out.println("Area Of rectangle is :" + rec * recb);
        System.out.println("Perimeter Of rectangle is :" + 2 * (rec + recb));
    }

    void cube() {
        System.out.println("Please Enter Side");
        Scanner sc = new Scanner(System.in);

        int cube_l = sc.nextInt();
        System.out.println("Volume Of cube is :" + (cube_l * cube_l * cube_l));
        System.out.println("Susface Area Of cube is :" + 6 * (cube_l * cube_l));
        System.out.println("Perimeter Of cube is :" + 12 * (cube_l));
    }

    void cuboid() {
        System.out.println("Please Enter Length");
        Scanner sc = new Scanner(System.in);

        int cuboid_l = sc.nextInt();
        System.out.println("Please Enter Breadth");
        int cuboid_b = sc.nextInt();
        System.out.println("Please Enter Hight");
        int cuboid_h = sc.nextInt();
        System.out.println("Volume Of cuboid is :" + (cuboid_l * cuboid_b * cuboid_h));
        System.out.println("Susface Area Of cuboid is :" + 2 * ((cuboid_l * cuboid_b) + (cuboid_b * cuboid_h) + (cuboid_l * cuboid_h)));
        System.out.println("Perimeter Of cuboid is :" + 4 * (cuboid_l + cuboid_b + cuboid_h));

    }

    void tringle() {
        System.out.println("Please Enter Hight");
        Scanner sc = new Scanner(System.in);

        int th = sc.nextInt();
        System.out.println("Please Enter Base");
        int tb = sc.nextInt();
        System.out.println("Area Of Tringle is :" + 12 * tb * th);
        System.out.println("Perimeter Of Tringle is :" + 12 * tb * th);
    }

}

public class Demo {

    public static void main(String[] args) {
        System.out.println("Dimension Calculator..");
        System.out.println("Menue..!");
        System.out.println("1. Circle");
        System.out.println("2. squre");
        System.out.println("3. cube");
        System.out.println("4. cuboid");
        System.out.println("5. Rectangle");
        System.out.println("6. tringle");

        System.out.println("Please Enter Choice...!");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        calculator cal = new calculator();

        switch (i) {
            case 1:
                cal.circle();
                break;

            case 2:
                cal.square();
                break;

            case 3:
                cal.cube();
                break;
            case 4:
                cal.cuboid();
                break;
            case 5:
                cal.rectangle();
                break;
            case 6:
                cal.tringle();
                break;
            default:
                System.out.println("Invalid Option..!");

        }

    }

}
