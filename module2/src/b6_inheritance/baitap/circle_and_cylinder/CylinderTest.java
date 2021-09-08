package b6_inheritance.baitap.circle_and_cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(9.5);
        System.out.println(cylinder);
        cylinder = new Cylinder(3.5, "black", 8.5);
        System.out.println(cylinder);
        System.out.println("Volumetric =" + cylinder.getVolumetric());
    }
}
