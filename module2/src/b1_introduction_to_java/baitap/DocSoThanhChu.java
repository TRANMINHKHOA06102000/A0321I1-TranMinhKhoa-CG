package b1_introduction_to_java.baitap;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: \n");
        int num = input.nextInt();
        System.out.println(ConVert.convert(num));
    }

    public static class ConVert {
        private static final String[] tensNames = {
                "",
                " ten",
                " twenty",
                " thirty",
                " forty",
                " fifty",
                " sixty",
                " seventy",
                " eighty",
                " ninety"
        };
        private static final String[] numNames = {
                "",
                " one",
                " two",
                " three",
                " four",
                " five",
                " six",
                " seven",
                " eight",
                " nine",
                " ten",
                " eleven",
                " twelve",
                " thirteen",
                " fourteen",
                " fifteen",
                " sixteen",
                " seventeen",
                " eighteen",
                " nineteen"
        };

        private static String convertLessThanOneHundred(int number) {
            String soFar;
            if (number % 100 < 20) {
                soFar = numNames[number % 100];
                number /= 100;
            } else {
                soFar = numNames[number % 10];
                number /= 10;

                soFar = tensNames[number % 10] + soFar;
                number /= 10;
            }
            if (number == 0) return soFar;
            return numNames[number] + " hundred" + soFar;
        }

        private static String convert(int number) {
            if (number == 0) {
                return "zero";
            }else if(number >999){
                return "Số vượt quá 999";
            }else{
                String result = convertLessThanOneHundred(number);
                return result;
            }
        }
    }
}
