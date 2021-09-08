package b1_introduction_to_java.baitap;

import java.util.Scanner;

public class ConvertMoney {
    public static void main(String[] args) {
        double vnd= 23000;
        double usd;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Mời bạn nhập số tiền USD: ");
        usd=scanner.nextDouble();
        double quydoi= usd*vnd;
        System.out.println("Giá Trị VNĐ: "+ quydoi);
    }
}
