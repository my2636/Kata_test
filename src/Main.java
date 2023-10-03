import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
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

        if(count==1) {
            throw new IOException("The string does not meet the conditions.");
        } else if(operator=="") {
            throw new IOException("There is no operator in the line.");
        }
        else if(count==input.toCharArray().length-1) {
            System.out.println(calc(input));
        } else if (count==0) {
            try {
                String[] nums = input.split("\\+|-|\\*|/");
                String[] nums1 = {getArabic(nums[0]), getArabic(nums[1])};
                String nums2 = nums1[0] + operator + nums1[1];
                String calc = calc(nums2);
                System.out.println(calc);
            } catch (Exception e) {
                System.out.println("Incorrect numbers format");
            }
        }
    }

    public static String calc(String input) throws IOException {
        String[] nums = input.split("\\+|-|\\*|/");
        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[1]);
        String c = "";
        if (a>0&&a<11&&b>0&&b<11){
            if (input.contains("+")) {
                c = Integer.toString(a + b);
            } else if (input.contains("-")) {
                c = Integer.toString(a - b);
            } else if (input.contains("*")) {
                c = Integer.toString(a * b);
            } else if (input.contains("/")) {
                c = Integer.toString(a / b);
            }
        } else {
            throw new IOException("A number out of range was detected");
        }

        return c;
    }

    static String getArabic(String in) {
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

        return map.get(in);
    }
}