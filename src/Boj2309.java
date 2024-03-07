import java.util.*;

public class Boj2309 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] tall = new int[9];
        int res = 0;

        for(int i = 0; i < 9; i++){
            tall[i] = sc.nextInt();
        }
        Arrays.sort(tall);

        for(int i = 0; i < 9; i++){
            res += tall[i];
        }

        for(int i = 0; i < 9; i++){
            for(int j = i+1; j < 9; j++){
                int test = res - (tall[i] + tall[j]);
                if(test == 100){
                    Arrays.sort(tall);
                    for(int z = 0; z < 9; z++){
                        if(z != i && z != j){
                            System.out.println(tall[z]);
                        }
                    }
                    return;
                }
            }
        }
    }
}
