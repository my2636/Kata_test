import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        calc(input);
}

    public static String calc(String input){
        String[] roman = {"X","I","II","III","IV","V","VI","VII","VIII","IX"};
        int[] arabic = new int[10];
        for(int i=0; i<arabic.length; i++) {
            arabic[i] = i+1;
        }
        System.out.println(Arrays.toString(arabic));
    return input;
    }

}