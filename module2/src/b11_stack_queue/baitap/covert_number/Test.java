package b11_stack_queue.baitap.covert_number;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chuyển đổi hệ cơ số: \n1. Decimal sang Binary và Hex\n2. Binary sang Decimal và  Hex" +
                "\n3. Hex sang Decimal và Binary\n");
        do {
            System.out.println("Nhập lựa chọn: ");
            choice = scanner.nextInt();
        } while (choice < 0 || choice > 3);
        switch (choice) {
            case 1: {
                int value;
                do {
                    System.out.print("Nhập số Decimal: ");
                    value = Integer.valueOf(scanner.nextLine());
                } while (!Decimal.isDecimal(value));
                Decimal decimal = new Decimal(value);
                System.out.println("Binary: " + decimal.toBinary().getValue());
                System.out.println("Hex: " + decimal.toHex().getValue());
                break;
            }
            case 2: {
                String value;
                do {
                    System.out.print("Nhập số Binary: ");
                    value = scanner.nextLine();
                } while (!Binary.isBinary(value));
                Binary binary = new Binary(value);
                System.out.println("Decimal: " + binary.toDecimal().getValue());
                System.out.println("Hex: " + binary.toHex().getValue());
                break;
            }
            case 3: {
                String value;
                do {
                    System.out.print("Nhập số Hexadecimal: ");
                    value = scanner.nextLine();
                } while (!Hexadecimal.isHex(value));
                Hexadecimal hex = new Hexadecimal(value);
                System.out.println("Decimal: " + hex.toDecimal().getValue());
                System.out.println("Binary: " + hex.toBinary().getValue());
                break;
            }
        }
    }
}
