package b3_array_and_method_in_java.baitap;

import java.util.Scanner;

public class CountCharacters {
    public static int countCharacters(String st, char ch) {
        int count = 0;
        for (int i = 0; i < st.length(); i++) {
            if (ch == st.charAt(i))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String st = scanner.nextLine();
        System.out.println("Nhập kí tự cần đếm: ");
        char ch = scanner.next().charAt(0);
        int count = countCharacters(st, ch);
        System.out.println("số lần xuất hiện của ký tự " + ch + " trong chuỗi " + st + " là : " + count);
    }
}
