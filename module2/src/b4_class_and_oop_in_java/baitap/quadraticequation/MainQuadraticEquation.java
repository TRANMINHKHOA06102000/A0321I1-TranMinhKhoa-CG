package b4_class_and_oop_in_java.baitap.quadraticequation;

import java.util.Scanner;

public class MainQuadraticEquation {
    public static void main(String[] args) {
        double a, b, c;
        double x1, x2, x3, x4, delta;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào a:");
        a = scanner.nextInt();
        System.out.println("Nhập vào b:");
        b = scanner.nextInt();
        System.out.println("Nhập vào c:");
        c = scanner.nextInt();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phuong trinh vo so nghiem");
                } else {
                    System.out.println("Phuong trinh vo nghiem");
                }
            } else {
                x4 = quadraticEquation.getRoot4();
                System.out.println("Phuong trinh co nghiem=" + x4);
            }
        } else {
            x1 = quadraticEquation.getRoot1();
            x2 = quadraticEquation.getRoot2();
            x3 = quadraticEquation.getRoot3();
            delta = quadraticEquation.getDiscriminant();
            if (delta < 0) {
                System.out.println("Phương trình vô nghiệm");
            } else if (delta == 0) {
                System.out.println("Phương trình có nghiệm kép =" + x3);
            } else {
                System.out.println("Phương trình co 2 nghiệm :\n x1=" + x1 + " \n x2=" + x2);
            }
        }
    }
}
