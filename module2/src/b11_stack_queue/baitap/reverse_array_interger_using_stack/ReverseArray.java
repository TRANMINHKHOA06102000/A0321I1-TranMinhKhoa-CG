package b11_stack_queue.baitap.reverse_array_interger_using_stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseArray {
    public static void main(String[] args) {
        Stack<Integer> stackInt = new Stack<>();
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < intArray.length; i++) {
            stackInt.push(intArray[i]);
        }
        System.out.println("Mảng ban đầu: ");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + "\t");
        }
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = stackInt.pop();
        }
        System.out.println("\nMảng sau khi đảo ngược: ");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + "\t");
        }
        //đảo ngược nếu là chuỗi
        /*System.out.println("\n ----------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String string = scanner.nextLine();
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i< string.length(); i++){
            characterStack.push(string.charAt(i));
        }
        while (!characterStack.isEmpty()){
            System.out.print(characterStack.pop());
        }
        System.out.println("\n ----------------------------------------------------------------------");
        System.out.print("Nhập chuỗi: ");
        String inputString = scanner.nextLine();
        String[] arrayString = inputString.split("\\s");
        Stack<String> stringStack = new Stack<>();
        for (int i=0 ; i< arrayString.length; i++){
            stringStack.push(arrayString[i]);
        }

        while (!stringStack.isEmpty()){
            System.out.print(stringStack.pop() +  " ");
        }*/
    }
}
