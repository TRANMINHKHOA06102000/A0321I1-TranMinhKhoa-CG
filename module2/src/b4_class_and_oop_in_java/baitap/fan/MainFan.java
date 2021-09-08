package b4_class_and_oop_in_java.baitap.fan;

public class MainFan {
    public static void main(String[] args) {
        Fan fan=new Fan();
        Fan fan1 = new Fan(Fan.FAST, true, 10,"yellow");
        Fan fan2 = new Fan(Fan.MEDIUM, false, 5,"blue");
        System.out.println(fan);
        System.out.println(fan1);
        System.out.println(fan2);
    }
}
