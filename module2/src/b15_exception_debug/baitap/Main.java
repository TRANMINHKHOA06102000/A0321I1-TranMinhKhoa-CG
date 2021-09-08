package b15_exception_debug.baitap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Three Double Side: ");
            double side1 = input.nextDouble();
            if (side1 <= 0) throw new Exception("please enter number > 0");
            double side2 = input.nextDouble();
            if (side2 <= 0) throw new Exception("please enter number > 0");
            double side3 = input.nextDouble();
            if (side3 <= 0) throw new Exception("please enter number > 0");
            Triangle triangle = new Triangle(side1, side2, side3);
            System.out.println("Valid triangle sides");
        } catch (IllegalTriangleException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
