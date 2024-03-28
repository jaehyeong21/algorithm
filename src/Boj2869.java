import java.util.Scanner;

public class Boj2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        // (V - B) = 미끄러지지않고 최대한 올라갈 수 있는 높이
        // (A - B ) 하루에 올라가는 높이
        int day = (V - B - 1) / (A - B) + 1;

        System.out.println(day);
    }
}
