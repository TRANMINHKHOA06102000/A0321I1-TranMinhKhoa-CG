package b3_array_and_method_in_java.baitap;

import java.util.Scanner;

public class SearchElementMaxInArray2D {
    public static int maxValue(int[][] array) {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                if (array[i][j] > max)
                    max = array[i][j];
        return max;
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
        int max = maxValue(array);
        System.out.print("Giá trị lớn nhất của mảng: " + max);
    }
}
