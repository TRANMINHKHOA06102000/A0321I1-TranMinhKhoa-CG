package b3_array_and_method_in_java.baitap;

import java.util.Scanner;

public class DeleteArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập kích thước mảng:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Kích thước không được lớn hơn 20");
        } while (size > 20);

        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhập giá trị " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Mảng ban đầu: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

        int X;
        int index = 0;
        System.out.print("\nNhập giá trị cần xóa: ");
        X = scanner.nextInt();
        for (int j = 0; j < array.length; j++) {
            if (X == array[j]) {
                index = j;
            }
        }

        for (int k = index; k < array.length - 1; k++) {
            array[k] = array[k + 1];
        }
        array[array.length - 1] = 0;
        System.out.print("Các phần tử trong mảng là: ");
        for (int l = 0; l < array.length; l++) {
            System.out.print(array[l] + "\t");
        }
    }
}
