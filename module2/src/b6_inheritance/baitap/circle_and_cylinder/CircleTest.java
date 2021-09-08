package b6_inheritance.baitap.circle_and_cylinder;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(9.1, "blue");
        System.out.println(circle);
        System.out.println("Area = " + circle.getArea() + ", Perimeter =" + circle.getPerimeter());
    }
}
