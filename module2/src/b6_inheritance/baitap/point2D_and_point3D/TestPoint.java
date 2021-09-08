package b6_inheritance.baitap.point2D_and_point3D;

public class TestPoint {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(5, 2);
        float[] arr1;
        arr1 = point2D.getXY();
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "\t");
        }

        System.out.println(point2D);

        Point3D point3D = new Point3D(point2D.getX(), point2D.getY(), 4);
        float[] arr2;
        arr2 = point3D.getXYZ();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + "\t");
        }
        System.out.println(point3D);
    }
}
