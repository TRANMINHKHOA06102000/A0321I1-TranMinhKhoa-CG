package b5_accessmodifier_staticmethod_staticproperty.baitap.modifierprotected;

import b5_accessmodifier_staticmethod_staticproperty.baitap.modifierpublic.Circle;

public class NewCircle extends Circle {
    public void print() {
        System.out.print(this.getRadius() + " - " + this.getColor());
    }
}