package b11_stack_queue.baitap.covert_number;

import java.util.Stack;

public class Decimal {
    private int value;

    public Decimal(){
        this.value = 0;
    }

    public Decimal(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Binary toBinary(){
        int decimalNumber = value;
        Stack<Integer> surPlus = new Stack<>();
        while (decimalNumber >= 1) {
            surPlus.push(decimalNumber % 2);
            decimalNumber /= 2;
        }
        String result = "";
        while (!surPlus.isEmpty()) {
            result = result.concat(String.valueOf(surPlus.pop()));
        }
        Binary binaryResult = new Binary(result);
        return binaryResult;
    }

    public Hexadecimal toHex(){
        String[] surPlusArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        int decimalNumber = this.value;
        Stack<String> surPlus = new Stack<>();
        while (decimalNumber >= 1) {
            surPlus.push(surPlusArray[decimalNumber % 16]);
            decimalNumber /= 16;
        }
        String result = "";
        while (!surPlus.isEmpty()) {
            result = result.concat(String.valueOf(surPlus.pop()));
        }
        Hexadecimal hexResult = new Hexadecimal(result);
        return hexResult;
    }

    public static boolean isDecimal(int number){
        if (number >= 0){
            return true;
        } else return false;

    }
}
