import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        calc(input);
    }

    public static String calc(String input) {
        String[] nums = input.split("\\+|-|\\*|/");
        if(input.contains("+")){
            System.out.println(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]));
        } else if(input.contains("-")){
            System.out.println(Integer.parseInt(nums[0]) - Integer.parseInt(nums[1]));
        } else if(input.contains("*")){
            System.out.println(Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]));
        } else if(input.contains("/")) {
            System.out.println(Integer.parseInt(nums[0]) / Integer.parseInt(nums[1]));
        }
        return input;
    }




    }
    enum roman {
        I(1),
        II(2),
        III(3),
        IV(4),
        V(5),
        VI(6),
        VII(7),
        VIII(8),
        IX(9),
        X(10),
        L(50),
        C(100);

        private int lable;
        roman(int s) {lable = s;}
        public int getLable() {return lable;}
    }

//String[] roman = {"X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//String[] signs = {"+", "-", "*", "/"};
//int i1 = input.indexOf("+");