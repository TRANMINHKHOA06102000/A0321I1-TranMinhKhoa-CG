package b6_inheritance.baitap.triangle;

public class TestTriangle {
    public static void main(String[] args) {
        Shape shape=new Shape();
        System.out.println(shape);

        shape=new Shape("blue",false);
        System.out.println(shape);

        Triangle triangle=new Triangle(shape.getColor(), shape.isFilled(), 3,4,5);
        System.out.println(triangle);

        System.out.println("Perimeter = "+triangle.getPerimeter()+", Area = "+triangle.getArea());

    }
}
