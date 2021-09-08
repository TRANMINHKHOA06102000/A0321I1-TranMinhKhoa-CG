package b6_inheritance.baitap.point2D_and_point3D;

public class Point3D extends Point2D {
    private float z;

    public Point3D() {
    }

    ;

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] array = {super.getX(), super.getY(), this.z};
        return array;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "z=" + z +
                '}' +
                ", which is a subclass of " +
                super.toString();
    }
}
