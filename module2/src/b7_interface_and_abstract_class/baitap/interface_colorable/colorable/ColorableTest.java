package b7_interface_and_abstract_class.baitap.interface_colorable.colorable;

import b7_interface_and_abstract_class.baitap.interface_colorable.circle.Circle;
import b7_interface_and_abstract_class.baitap.interface_colorable.rectangle.Rectangle;
import b7_interface_and_abstract_class.baitap.interface_colorable.shape.Shape;
import b7_interface_and_abstract_class.baitap.interface_colorable.square.Square;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(5, 9);
        shapes[2] = new Square(7);

        for (Shape shape : shapes) {
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
