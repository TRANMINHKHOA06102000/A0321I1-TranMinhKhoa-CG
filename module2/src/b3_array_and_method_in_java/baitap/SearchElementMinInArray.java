package b3_array_and_method_in_java.baitap;

import java.util.Scanner;

public class SearchElementMinInArray {
    public static int minValue(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] < min)
                min = array[i];
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array;
        do {
            System.out.print("Nhập kích thước mảng:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Kích thước không được lớn hơn 20");
        } while (size > 20);

        array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Phần tử [%d] = ", i);
            array[i] = scanner.nextInt();
        }
        int min = minValue(array);
        System.out.print("Giá trị nhỏ nhất của mảng là: " + min);
    }

}
