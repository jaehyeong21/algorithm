import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        String str = null;
        int A = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()){
            int B = Integer.parseInt(st.nextToken());
            if(A+1 == B){
                A = B;
                if(B == 8){
                    str = "ascending";
                }
            }
            else if(A-1 == B){
                A = B;
                if(B == 1){
                    str = "descending";
                }
            }
            else{
                str = "mixed";
            }
        }
        System.out.println(str);
    }
}
