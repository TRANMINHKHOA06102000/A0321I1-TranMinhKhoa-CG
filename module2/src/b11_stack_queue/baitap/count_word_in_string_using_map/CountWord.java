package b11_stack_queue.baitap.count_word_in_string_using_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String: ");
        String input = scanner.nextLine();
        input = input.trim().toLowerCase();
        String[] stringArrray = input.split("\\s+");
        Map<String, Integer> countWord = new HashMap<String, Integer>();

        for (String string : stringArrray) {
            if (countWord.containsKey(string)) {
                Integer newValue = countWord.get(string) + 1;
                countWord.put(string, newValue);
            } else {
                countWord.put(string, 1);
            }
        }

        for (String key : countWord.keySet()) {
            System.out.println(key + " : " + countWord.get(key));
        }

    }
}
