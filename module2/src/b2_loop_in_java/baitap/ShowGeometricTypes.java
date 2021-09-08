package b2_loop_in_java.baitap;

import java.util.Scanner;

public class ShowGeometricTypes {

    public static void rectangle(){
        System.out.println("Print the rectangle");
        int lenght, width;
        Scanner input = new Scanner(System.in);
        System.out.println("input lenght : ");
        lenght = input.nextInt();
        System.out.println("input width: ");
        width = input.nextInt();
        for (int i = 1; i <= lenght; i++) {
            for (int j = 1; j <= width; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }
    public static void square_triangle(){
        System.out.println("Print the square triangle");
        int hight;
        System.out.println("input hight: ");
        Scanner input = new Scanner(System.in);
        hight = input.nextInt();
        System.out.println("Print the square triangle: top-left");

        for (int i = 1; i <= hight; i++) {
            for (int j = hight; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

        System.out.println("Print the square triangle: top-right");
        for (int i = 0; i < hight; i++) {
            for (int j = 0; j < i; j++)
                System.out.print("  ");
            for (int j = i; j < hight; j++)
                System.out.print("* ");
            System.out.print("\n");
        }
        System.out.print("\n");

        System.out.println("Print the square triangle: botton-left");
        for (int i = 1; i <= hight; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.println("\n");

        System.out.println("Print the square triangle: botton-right");
        for (int i = hight; i >= 1; i--) {
            for (int j = 1; j <= hight; j++) {
                if (j < i) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.print("\n");
        }
    }
    public static void isosceles_triangle(){
        System.out.println("Print isosceles triangle");
        System.out.println("input hight: ");
        Scanner input = new Scanner(System.in);
        int hight;
        hight = input.nextInt();
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= hight; j++) {
                if (j < i) {
                    System.out.print(" ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args) {
        int choice1 = -1;
        Scanner input = new Scanner(System.in);
        while (choice1 != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice1 = input.nextInt();
            switch (choice1) {
                case 1:
                    rectangle();
                    break;
                case 2:
                    square_triangle();
                    break;
                case 3:
                    isosceles_triangle();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
