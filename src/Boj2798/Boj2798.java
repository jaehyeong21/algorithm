package Boj2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 class Boj2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int N = Integer.parseInt(st.nextToken()); // 카드 수
        int M = Integer.parseInt(st.nextToken()); // 합
        int MaxValue = 0;

        int[] arr = new int[N];

        String str2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(str2, " ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        for(int i = 0; i < N-2; i++){
            for(int j = i+1; j < N-1; j++){
                for(int z = j+1; z < N; z++){
                    int sum = arr[i] + arr[j] + arr[z];
                    if(M > sum){
                        if(MaxValue <= sum){
                            MaxValue = sum;
                        }
                    }
                }
            }
        }

        System.out.print(MaxValue);

    }
}
