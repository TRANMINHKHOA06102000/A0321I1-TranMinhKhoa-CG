package b3_array_and_method_in_java.baitap;

import java.util.Scanner;

public class SumOfDiagonal {
    public static int sumDiagonal(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i][i];
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng: ");
        int size = scanner.nextInt();
        ;
        int[][] array = new int[size][size];
        System.out.println("Nhập Phần tử: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("Phần tử [%d][%d] = ", i, j);
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Mảng đã nhập: ");
        for (int k = 0; k < size; k++) {
            for (int l = 0; l < size; l++) {
                System.out.printf(array[k][l] + " ");
            }
            System.out.printf("\n");
        }
        System.out.print("Tổng đường chéo chính của ma trận vuông: " + sumDiagonal(array));
    }
}
