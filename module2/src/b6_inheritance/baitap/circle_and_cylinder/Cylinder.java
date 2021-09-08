package b6_inheritance.baitap.circle_and_cylinder;

public class Cylinder extends Circle{
    private double height=1.0;
    public Cylinder(){}

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolumetric(){
        return getArea()*height;
    }

    @Override
    public String toString() {
        return "A Circle with height=" +
                getHeight()+
                ", which is a subclass of " +
                super.toString();
    }
}
