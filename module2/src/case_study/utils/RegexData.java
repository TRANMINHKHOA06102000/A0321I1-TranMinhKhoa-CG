package case_study.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    static Scanner scanner = new Scanner(System.in);

    private static String regex = "";

    public static boolean checkIdVilla(String id) {
        regex = "(SVVL)[-][\\d]{4}";
        return id.matches(regex);
    }

    public static boolean checkIdHouse(String id) {
        regex = "(SVHO)[-][\\d]{4}";
        return id.matches(regex);
    }

    public static boolean checkIDRoom(String id) {
        regex = "(SVRO)[-][\\d]{4}";
        return id.matches(regex);
    }

    public static boolean checkNameAndStandard(String str) {
        regex = "[A-Z][a-z]+";
        return str.matches(regex);
    }

/*    public static boolean checkAreaAndAreaPool(int area) {
        int areaNum;
        try {
            areaNum = area;
            return areaNum > 30;
        } catch (Exception Ex) {
            return false;
        }
    }*/
    public static boolean checkAreaOrAreaPool(int area){
        String area1= String.valueOf(area);
        regex = "^([3-9]\\d|[1-9]\\d{2,})";
        return area1.matches(regex);
    }
   /* public static boolean checkPrice(double price){
        String price1= String.valueOf(price);
        regex = "^([1-9])[0-9]*$";
        return price1.matches(regex);
    }*/
    public static boolean checkPrice(double price) {
        double priceNum;
        try {
            priceNum = price;
            return priceNum > 0;
        } catch (Exception ex) {
            return false;
        }
    }
    /*public static boolean checkAmount(int amount){
        String amount1= String.valueOf(amount);
        regex = "^[1-9]|([1][0-9])|(20)$";
        return amount1.matches(regex);
    }*/
    public static boolean checkAmount(int amount) {
        int amountNum;
        try {
            amountNum = amount;
            return amountNum > 0 && amountNum < 20;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean checkNumberOfFloors(int floor) {
        int floorNum;
        try {
            floorNum = floor;
            return floorNum > 0;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean checkTypeRent(String typeRents) {
        regex = "(year)|(month)|(day)|(hour)";
        return typeRents.matches(regex);
    }

    public static String regexAge(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();

                    int current = Period.between(age, now).getYears();
                    if (current < 100 && current > 18) {
                        check = false;
                    } else {
                        throw new AgeException("Age >18 and Age<100");
                    }
                } else {
                    throw new AgeException("input format is not correct");
                }
            } catch (AgeException ex) {
                System.out.println(ex.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }
    public static String regexString(String temp, String regex, String error) {
        boolean check = true;
        do {
            if (temp.matches(regex)) {
                check = false;
            } else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        } while (check);
        return temp;
    }
}
