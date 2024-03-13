import java.util.Scanner;

public class Boj10250 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리

        for (int t = 0; t < T; t++) {
            int H, W, N;
            int A = 1;

            String[] str = sc.nextLine().split(" ");
            H = Integer.parseInt(str[0]);
            W = Integer.parseInt(str[1]);
            N = Integer.parseInt(str[2]);

            int[][] array = new int[H][W];

            for(int i = 0; i < H; i++){
                A = A + 100;
                for(int j = 0; j < W; j++){
                    array[i][j] = A + j;
                }
            }

            int floor = N % H;
            int room = N / H + 1;

            if (floor == 0) { // 층이 예를들어 6층이고 N이 11이라면 나머지 결과가 5,
                // 즉 5층임 그러면 6층이고 N이 12라면 나머지는 0층인데 결과가 말이 안됨(꼭대기 층은 예외)
                // , 고로 나머지가 0이면 N을 맨 꼭대기로 층으로 수정 room - 1 이유도 방 번호를 하나 줄여
                // 줘야함, 그렇지 않으면 맨 꼭대기 층의 번호와 일치하지 않음
                floor = H;
                room -= 1;
            }

            System.out.println(array[floor - 1][room - 1]); //인덱스는 0부터 시작하기에 1씩 빼줘야함
        }
    }
}
