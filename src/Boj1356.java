import java.util.Scanner;

public class Boj1356 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int len = str.length();

        boolean result = false;

        for (int i = 1; i < len; i++) {
            int leftProduct = 1;
            int rightProduct = 1;

            for (int j = 0; j < i; j++) {
                leftProduct *= str.charAt(j) - '0'; // '0'의 아스키 코드 값이 48
            }
            for (int j = i; j < len; j++) {
                rightProduct *= str.charAt(j) - '0';
            }
            if (leftProduct == rightProduct) {
                result = true;
                break;
            }
        }

        System.out.println(result ? "YES" : "NO");
    }
}