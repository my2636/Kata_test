import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Условия ввода: \nТолько римские или только арабские числа в одну строку без " +
                "лишних символов, от 1 до 10 включительно. \n1 оператор из 4 допустимых: +-*/, не больше и не меньше." +
                "\nПервое римское число строго больше второго. ");
        String input = new Scanner(System.in).nextLine();
        int count = 0;
        int opCount = 0;
        String operator = "";
        String a = "";
        String b = "";
        for(char c: input.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            } else if (c == '+') {
                operator = "+";
                opCount++;
            } else if (c == '-') {
                operator = "-";
                opCount++;
            } else if (c == '*') {
                operator = "*";
                opCount++;
            } else if (c == '/') {
                operator = "/";
                opCount++;
            } else {
                try {
                    String[] nums = input.split("\\+|-|\\*|/");
                    a = getArabic(nums[0]);
                    b = getArabic(nums[1]);
                } catch (Exception e) {
                    throw new IOException("The string does not meet the conditions.");
                }
            }
        }

        if(count==1) {
            throw new IOException("The string does not meet the conditions.");
        } else if (operator=="") {
            throw new IOException("There is no operator in the line.");
        } else if (opCount>1){
            throw new IOException("There is more than one operator");
        } else if (count==input.toCharArray().length-1) {
            System.out.println(calc(input));
        } else if (count==0&&a!=""&&b!="") {
            try {
                String[] nums = input.split("\\+|-|\\*|/");
                String[] nums1 = {getArabic(nums[0]), getArabic(nums[1])};
                String nums2 = nums1[0] + operator + nums1[1];
                String stringCalc = calc(nums2);
                if (Integer.parseInt(stringCalc)>0&&Integer.parseInt(stringCalc)!=0) {
                    System.out.println(stringCalc);
                } else {
                    throw new IOException("illegal operation with Roman numerals");
                }
            } catch (Exception e) {
                System.out.println("Incorrect numbers format!");
            }
        }
    }

    public static String calc(String input) throws IOException {
        String[] nums = input.split("\\+|-|\\*|/");
        int d = Integer.parseInt(nums[0]);
        int e = Integer.parseInt(nums[1]);
        String f = "";
        if (d>0&&d<11&&e>0&&e<11){
            if (input.contains("+")) {
                f = Integer.toString(d + e);
            } else if (input.contains("-")) {
                f = Integer.toString(d - e);
            } else if (input.contains("*")) {
                f = Integer.toString(d * e);
            } else if (input.contains("/")) {
                f = Integer.toString(d / e);
            }
        } else {
            throw new IOException("A number out of range was detected");
        }

        return f;
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