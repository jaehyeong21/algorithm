import java.util.Arrays;
import java.util.Scanner;

public class Boj2992 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numStr = scanner.nextLine();
        char[] numArr = numStr.toCharArray();
        int n = numArr.length;

        // 첫번째 감소하는 위치 찾기
        int i = n - 1;
        while (i > 0 && numArr[i - 1] >= numArr[i]) {
            i--;
        }

        // 모든 숫자가 내림차순인 경우
        if (i == 0) {
            System.out.println(0);
        } else {
            int j = n - 1;

            // i-1 위치의 숫자보다 큰 첫번째 숫자 찾기
            while (numArr[j] <= numArr[i - 1]) {
                j--;
            }

            // 숫자 교환
            char temp = numArr[i - 1];
            numArr[i - 1] = numArr[j];
            numArr[j] = temp;

            // i 위치부터 끝까지 오름차순 정렬
            Arrays.sort(numArr, i, n);

            // 결과 출력
            System.out.println(new String(numArr));
        }
    }
}
