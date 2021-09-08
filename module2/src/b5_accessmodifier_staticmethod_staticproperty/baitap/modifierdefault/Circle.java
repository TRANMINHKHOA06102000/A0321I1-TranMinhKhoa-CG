package b5_accessmodifier_staticmethod_staticproperty.baitap.modifierdefault;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    double getRadius() {
        return radius;
    }

    String getColor() {
        return color;
    }
}
