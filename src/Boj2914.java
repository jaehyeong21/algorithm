import java.util.*;

public class Boj2914 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] strings = str.split(" ");

        double a = Integer.parseInt(strings[0]);
        double b = Integer.parseInt(strings[1]);

        b = b - 1;

        double result = a * b;

        System.out.print((int)(result + 1));
    }
}
