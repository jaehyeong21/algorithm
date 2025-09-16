package Boj1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Boj1427 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String s = String.valueOf(N);

        char[] chars = s.toCharArray();

        Integer[] M = new Integer[chars.length];

        for(int i = 0; i < chars.length; i++){
            M[i] = chars[i] - '0';
        }

        Arrays.sort(M, Collections.reverseOrder());

        for(int j = 0; j < M.length; j++){
            System.out.print(M[j]);
        }

    }
}
