import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Условия ввода: \nТолько целые, только римские или только арабские числа в одну строку без " +
                "лишних символов, от 1 до 10 включительно. \n1 оператор из 4 допустимых: +-*/, не больше и не меньше." +
                "\nПервое римское число строго больше второго.");
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
            if (Integer.parseInt(a)>Integer.parseInt(b)) {
                String st  = calc(a+operator+b);
                System.out.println(st);
                int intt = Integer.parseInt(st);
                if (intt<10||intt%1==0||intt==100) {
                    System.out.println(getArabicRoman(st));
                } else {
                    String y = getArabicRoman(Integer.toString(intt-(intt%10)));
                    System.out.println(y);
                    String z = getArabicRoman(Integer.toString(intt%10));
                    System.out.println(z);
                    System.out.println(y+z);
                }
            }
        } else {
                throw new IOException("illegal operation with Roman numerals");
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
        map.put("30", "XX");
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

/*

I = 1
V = 5
X = 10
L = 50
C = 100





I II III IV V VI VII VIII IX X
XI XII XIII XIV XV XVI XVII XVIII XIX XX
XXI XXII XXIII XXIV




 */