package b3_array_and_method_in_java.baitap;

import java.util.Scanner;

public class MergeArray {
    public static int[] initArray(String arrayName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input length of " + arrayName + ": ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%d] = ", arrayName, i);
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int temp[] = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++)
            temp[i] = arr1[i];
        for (int i = 0; i < arr2.length; i++)
            temp[arr1.length + i] = arr2[i];
        return temp;
    }

    public static void main(String[] args) {
        int[] array_1 = initArray("array_1");
        int[] array_2 = initArray("array_2");
        int[] array = mergeArrays(array_1, array_2);
        System.out.println("Combine 2 arrays:");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + "\t");
    }
}
