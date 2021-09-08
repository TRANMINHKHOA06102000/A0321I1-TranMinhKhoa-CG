package b4_class_and_oop_in_java.baitap.quadraticequation;


public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        double delta = b * b - 4 * a * c;
        return delta;
    }

    public double getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public double getRoot1() {
        double r1 = ((-b + Math.sqrt(getDiscriminant())) / (2 * a));
        return r1;
    }

    public double getRoot2() {
        double r2 = ((-b - Math.sqrt(getDiscriminant())) / (2 * a));
        return r2;
    }

    public double getRoot3() {
        double r3 = -b / (2 * a);
        return r3;
    }

    public double getRoot4() {
        double r4 = -c / b;
        return r4;
    }
}
