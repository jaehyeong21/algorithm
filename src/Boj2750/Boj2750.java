package Boj2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];

        for(int i = 0; i < N; i++){
            int A = Integer.parseInt(br.readLine());
            arr[i] = A;
        }

        Arrays.sort(arr);

        for(int j = 0; j < N; j++){
            System.out.println(arr[j]);
        }
    }
}
