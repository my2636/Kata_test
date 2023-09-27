import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        if (input.matches("\\+|-|\\*|/")){
            System.out.println(calc(input));
        } else {
            System.out.println("(");
        }
    }

    public static String calc(String input) {
        String[] nums = input.split("\\+|-|\\*|/");
        int a = 0;
        try{
           int c = getArabic(nums[0]);
           int d = getArabic(nums[1]);
            if(c>0&&c<11&&d>0&&d<11){
                switch (input){
                    case "+":
                        a = c+d;
                        break;
                    case "-":
                        a = c-d;
                        break;
                    case "*":
                        a = c*d;
                        break;
                    case "/":
                        a = c/d;
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("(((");
            }
        } catch (Exception e) {
            System.out.println("(");
        }

        try {
            int c = Integer.parseInt(nums[0]);
            int d = Integer.parseInt(nums[1]);
            if(c>0&&c<11&&d>0&&d<11){
                switch (input){
                    case "+":
                        a = c+d;
                        break;
                    case "-":
                        a = c-d;
                        break;
                    case "*":
                        a = c*d;
                        break;
                    case "/":
                        a = c/d;
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("(((");
            }
        } catch (Exception f) {
            System.out.println("((");
        }
        return Integer.toString(a);
    }
    static int getArabic(String a){
        enum Roman {
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
            Roman(int s) {lable = s;}
            public int getLable() {return lable;}
        }
            int r = Roman.valueOf(a).getLable();
            System.out.println(r);
        return r;
    }
}