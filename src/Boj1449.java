import java.util.Arrays;
import java.util.Scanner;

public class Boj1449 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split(" ");
        int N = Integer.parseInt(str[0]); // 물이 새는 곳의 개수
        int L = Integer.parseInt(str[1]); // 테이프의 길이 L

        int[] locations = new int[N];
        for (int i = 0; i < N; i++) {
            locations[i] = Integer.parseInt(sc.next());
        }

        Arrays.sort(locations);

        int count = 0; // 필요한 테이프의 개수를 저장할 변수
        int coveredRange = 0; // 현재까지 테이프로 막은 구간의 끝 위치를 저장할 변수

        for (int i = 0; i < N; i++) {
            if (coveredRange < locations[i]) { // 현재 위치가 이전까지 테이프로 막은 구간의 끝보다 멀리 있을 경우
                coveredRange = locations[i] + L - 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
