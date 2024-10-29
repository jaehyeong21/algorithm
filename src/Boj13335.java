import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭 개수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중

        int truck[] = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            truck[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> bridge = new LinkedList<>();

        for(int i = 0; i < w; i++){
            bridge.offer(0);
        }

        int weightBridge = 0;
        int time = 0;
        int index = 0;

        while(!bridge.isEmpty()){
            time++;
            weightBridge = weightBridge - bridge.poll();

            if(index < n){
                if(weightBridge + truck[index] <= L){
                    bridge.offer(truck[index]);
                    weightBridge += truck[index];
                    index++;
                }else{
                    bridge.offer(0);
                }
            }
        }

        System.out.println(time);
    }
}
