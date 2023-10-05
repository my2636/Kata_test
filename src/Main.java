import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
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
                    a = getArabicRoman(nums[0]);
                    b = getArabicRoman(nums[1]);
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
        }else if (count==input.toCharArray().length-1) {
            System.out.println(calc(input));
        } else if (count==0&&a!=""&&b!="") {
            if (operator=="-"&&Integer.parseInt(a)<Integer.parseInt(b)) {
                throw new IOException("illegal operation with Roman numerals");
            } else {
                String st = calc(a+operator+b);
                int intt = Integer.parseInt(st);
                if (intt<10||intt%10==0||intt==100) {
                System.out.println(getArabicRoman(st));
                } else {
                    char[] chars = st.toCharArray();
                    String s1 = getArabicRoman(Integer.toString(Character.getNumericValue(chars[0])*10));
                    String s2 = getArabicRoman(Character.toString(chars[1]));
                    System.out.println(s1 + s2);
                }
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

    static String getArabicRoman(String in) {
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
        map.put("XX", "20");
        map.put("XXX", "30");
        map.put("XL", "40");
        map.put("L", "50");
        map.put("LX", "60");
        map.put("LXX", "70");
        map.put("LXXX", "80");
        map.put("XC", "90");
        map.put("C", "100");

        map.put("1", "I");
        map.put("2", "II");
        map.put("3", "III");
        map.put("4", "IV");
        map.put("5", "V");
        map.put("6", "VI");
        map.put("7", "VII");
        map.put("8", "VIII");
        map.put("9", "IX");
        map.put("10", "X");
        map.put("20", "XX");
        map.put("30", "XXX");
        map.put("40", "XL");
        map.put("50", "L");
        map.put("60", "LX");
        map.put("70", "LXX");
        map.put("80", "LXXX");
        map.put("90", "XC");
        map.put("100", "C");

        return map.get(in);
    }
}