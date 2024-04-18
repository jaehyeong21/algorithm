import java.util.ArrayList;
import java.util.Scanner;

public class Boj17610 {

    //static(정적) 변수를 만들 때는 반드시 초기값이 필요 => 한번만 초기화가 발생
    //1~S까지 무게를 만들 수 있는 무게를 저장
    //무게를 만들 수 있다면 1, 없다면 0을 저장
    public static ArrayList<Integer> check = new ArrayList<>();

    public static int k = 0;
    public static int g[] = new int[13];

    public static void calculate(int idx, int X){
        //종료조건
        if(idx == k){
            //만들 수 있는 무게(X)가 0보다 크고, check에 있지 않으면 추가한다.
            if(X > 0 && !check.contains(X)){
                check.add(X);
            }
            return;
        }
        calculate(idx+1, X); //idx번째 추를 사용하지 않는 경우'
        calculate(idx+1, X-g[idx]); //idx번째 추를 왼쪽에 사용한 경우
        calculate(idx+1, X+g[idx]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt(); //추의 개수
        int s = 0; //추들의 총 합

        for(int i = 0; i < k; i++){
            g[i] = sc.nextInt();
            s =  s + g[i];
        }

        calculate(0,0);
        System.out.println(s - check.size());
    }
}
