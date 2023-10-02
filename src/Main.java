import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        int count = 0;
        for(char c: input.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }

        if(count>0) {
            System.out.println(calc(input));
        } else {
            try {
                String[] nums = getArabic(input);
            } catch (Exception e) {
                System.out.println("Exception 1");
            }
        }
    }

    public static String calc(String input) {
        String[] nums = input.split("\\+|-|\\*|/");
        String a = "";
        if (input.contains("+")) {
            a = Integer.toString(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]));
        } else if (input.contains("-")) {
            a = Integer.toString(Integer.parseInt(nums[0]) - Integer.parseInt(nums[1]));
        } else if (input.contains("*")) {
            a = Integer.toString(Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]));
        } else if (input.contains("/")) {
            a = Integer.toString(Integer.parseInt(nums[0]) / Integer.parseInt(nums[1]));
        }
        return a;
    }

    static String[] getArabic(String input) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);
        String[] nums = input.split("\\+|-|\\*|/");
        try {
            String a = map.get(nums[0]).toString();
            String b = map.get(nums[1]).toString();
            nums[0] = a;
            nums[1] = b;
            System.out.println(Arrays.toString(nums));
        } catch ( NoSuchElementException e) {
            System.out.println("exception (");
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}