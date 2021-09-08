package b6_inheritance.baitap.point_and_moveablePoint;

public class TestMoveablePoint {
    public static void main(String[] args) {
        Point point = new Point(8, 9);
        System.out.println(point);

        MoveablePoint moveablePoint = new MoveablePoint(point.getX(), point.getY(), 4, 5);
        System.out.println(moveablePoint);

        moveablePoint.move();
        System.out.println(moveablePoint);
    }
}
