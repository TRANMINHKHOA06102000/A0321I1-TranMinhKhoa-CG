import java.util.Scanner;

public class Main implements Calculator {
    @Override
    public int plus(int arg1, int arg2) {
        return arg1+arg2;
    }

    @Override
    public int subtract(int arg1, int arg2) {
        return arg1-arg2;
    }

    @Override
    public int multiply(int arg1, int arg2) {
        return arg1*arg2;
    }

    @Override
    public double divide(int arg1, int arg2) {
        return arg1/arg2;
    }

    public static void main(String[] args) {
        Main m= new Main();
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số 1");
        int a=sc.nextInt();
        System.out.println("Nhập số 2");
        int b=sc.nextInt();
        System.out.println("Phép cộng \n"+m.plus(a,b)+"\n");
        System.out.println("Phép trừ \n"+m.subtract(a,b)+"\n");
        System.out.println("Phép nhân \n"+m.multiply(a,b)+"\n");
        System.out.println("Phép chia \n"+m.divide(a,b)+"\n");
    }
}
