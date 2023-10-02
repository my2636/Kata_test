import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        int count = 0;
        String operator = "";
        for(char c: input.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            } else if (c == '+') {
                operator = "+";
            } else if (c == '-') {
                operator = "-";
            } else if (c == '*') {
                operator = "*";
            } else if (c == '/') {
                operator = "/";
            }
        }

        if(count>0) {
            System.out.println(calc(input));
        } else if (count==0) {
            try {
                System.out.println(calc(getArabic(input, operator)));
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

    static String getArabic(String input, String operator) {
        HashMap<String, String> map = new HashMap<>();
        map.put("I","1");
        map.put("II", "2");
        map.put("III", "3");
        map.put("IV", "4");
        map.put("V", "5");
        map.put("VI", "6");
        map.put("VII", "7");
        map.put("VIII", "8");
        map.put("IX", "9");
        map.put("X", "10");
        String[] nums = input.split("\\+|-|\\*|/");
        String c = "";
        try {
            String a = map.get(nums[0]);
            String b = map.get(nums[1]);
            c = a + operator + b;
        } catch ( NoSuchElementException e) {
            System.out.println("exception (");
        }
        return c;
    }
}