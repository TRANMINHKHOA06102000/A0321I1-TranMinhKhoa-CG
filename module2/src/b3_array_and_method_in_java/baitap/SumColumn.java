package b3_array_and_method_in_java.baitap;

import java.util.Scanner;

public class SumColumn {
    public static int sumColumn(int column, int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i][column];
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số dòng: ");
        int row = scanner.nextInt();
        System.out.print("Nhập số cột: ");
        int column = scanner.nextInt();
        int array[][] = new int[row][column];
        System.out.println("Nhập Phần tử: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.printf("Phần tử [%d][%d] = ", i, j);
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Mảng đã nhập: ");
        for (int k = 0; k < row; k++) {
            for (int l = 0; l < column; l++) {
                System.out.printf(array[k][l] + " ");
            }
            System.out.printf("\n");
        }

        System.out.print("\nNhập cột bạn muốn tính tổng: ");
        int sumColumn = scanner.nextInt();
        if (sumColumn < 0 || sumColumn >= column) {
            System.out.print("Cột bạn nhập không tồn tại");
        } else {
            int sum = sumColumn(sumColumn, array);
            System.out.print("Tổng các phần tử trong cột " + sumColumn + ": " + sum);
        }
    }
}
