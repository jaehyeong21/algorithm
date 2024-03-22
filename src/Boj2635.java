import java.util.ArrayList;
import java.util.Scanner;

public class Boj2635 {
    public static void main(String[] args){
        //그리디 => 당장에 해답을 찾기에 좋아보이는 방법
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mlen = 1;
        //최대 길이를 가지는 수열
        ArrayList<Integer> ans = new ArrayList<>();

        //두번째 수를 정해서 수열 만들기
        for(int i = n/2; i<=n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(n); //첫번째 수
            temp.add(i); //두번째 수
            int idx = 1;
            //음수가 나올때까지 수열 만들기
            while(true){
                //세번째 수 = 첫번째 수 - 두번째 수
                int next = temp.get(temp.size() - 2) - temp.get(temp.size() - 1);
                if(next < 0) break;
                temp.add(next);
                idx++;
            }
            if(mlen < temp.size()){
                mlen = temp.size(); // 가장 긴 수열의 길이
                ans = temp; // 가장 긴 길이를 가지는 수열
            }
        }
        System.out.println(mlen);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
