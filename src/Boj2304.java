import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2304 {

    public static void main(String[] args) throws IOException {
        int[] arr = new int[1001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 1001;
        int end = 0;
        int highest = 0;
        int highest_l = 0;

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[l] = h;

            //시작 위치
            start = Math.min(l,start);
            //끝 위치
            end = Math.max(l, end);

            if(h > highest) {
                highest = h;
                highest_l = l;
            }
        }

        int area = arr[start]; //창고 다각형의 너비
        Stack<Integer> high = new Stack<>();
        high.push(arr[start]); //4 최대값을 비교하기 위한 용도
        for(int i=start+1; i<=highest_l; i++){
            if(arr[i] <= high.peek()) {
                area+=high.peek();
            } else{
                high.push(arr[i]);
                area += high.peek();
            }
        }

        high.clear();
        high.push(arr[end]);
        area+=arr[end];
        for(int i=end-1; i>highest_l; i--) {
            if(arr[i] <= high.peek()){
                area+=high.peek();
            }else {
                high.push(arr[i]);
                area+=high.peek();
            }
        }

        if(highest_l == end) area -= arr[end];

        System.out.println(area);

    }
}
