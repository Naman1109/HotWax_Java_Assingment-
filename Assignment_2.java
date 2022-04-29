package Core_Java_Assignments;

import java.util.Scanner;

public class Assignment_2 {

    public static void main(String[] args) {

        System.out.println("Welcome to Shape Calculator...");
        System.out.println("Please Enter Shape name..!");
        Scanner sc = new Scanner(System.in);
        String shape = sc.next();

        switch (shape) {
            case "circle":
                System.out.println("Please Enter Radious");
                int r = sc.nextInt();

                System.out.println("Area Of circle is :" + 3.14 * (r * r));
                System.out.println("Perimeter Of Ciecle is :" + 2 * 3.14 * r);
                break;

            case "tringle":
                System.out.println("Please Enter Hight");
                int th = sc.nextInt();
                System.out.println("Please Enter Base");
                int tb = sc.nextInt();
                System.out.println("Area Of Tringle is :" + 12 * tb * th);
                System.out.println("Perimeter Of Tringle is :" + 12 * tb * th);
                break;

            case "square":
                System.out.println("Please Enter Length");
                int a = sc.nextInt();
                System.out.println("Area Of Square is :" + a * a);
                System.out.println("Perimeter Of Square is :" + 4 * a);
                break;
            case "cylinder":
                System.out.println("Please Enter Radious");
                int cr = sc.nextInt();
                System.out.println("Please Enter Hight");
                int ch = sc.nextInt();

                System.out.println("Volume Of cylinder is :" + 3.14 * (cr * cr) * ch);
                System.out.println("Susface Area Of cylinder is :" + 2 * 3.14 * cr * ch);
                System.out.println("Area Of cylinder is :" + 2 * 3.14 * cr * (ch + cr));

                break;
            case "rectangle":
                System.out.println("Please Enter Length");
                int rec = sc.nextInt();
                System.out.println("Please Enter Breadth");
                int recb = sc.nextInt();
                System.out.println("Area Of rectangle is :" + rec * recb);
                System.out.println("Perimeter Of rectangle is :" + 2 * (rec + recb));
                break;

            case "cube":
                System.out.println("Please Enter Side");
                int cube_l = sc.nextInt();
                System.out.println("Volume Of cube is :" + (cube_l * cube_l * cube_l));
                System.out.println("Susface Area Of cube is :" + 6 * (cube_l * cube_l));
                System.out.println("Perimeter Of cube is :" + 12 * (cube_l));

                break;
            case "cuboid":
                System.out.println("Please Enter Length");
                int cuboid_l = sc.nextInt();
                System.out.println("Please Enter Breadth");
                int cuboid_b = sc.nextInt();
                System.out.println("Please Enter Hight");
                int cuboid_h = sc.nextInt();
                System.out.println("Volume Of cuboid is :" + (cuboid_l * cuboid_b * cuboid_h));
                System.out.println("Susface Area Of cuboid is :" + 2 * ((cuboid_l * cuboid_b) + (cuboid_b * cuboid_h) + (cuboid_l * cuboid_h)));
                System.out.println("Perimeter Of cuboid is :" + 4 * (cuboid_l + cuboid_b + cuboid_h));

                break;

            default:
                System.out.println("You Entered Figure is Not Valid");
        }

    }

}
