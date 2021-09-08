package b5_accessmodifier_staticmethod_staticproperty.baitap;

class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    private double getRadius() {
        return radius;
    }

    private String getColor() {
        return color;
    }

}

public class Modifierprivate {
    public static void main(String args[]) {
        Circle obj = new Circle();
        //Compile Time Error
        /*System.out.println(obj.getRadius() + obj.getColor();*/

    }
}
