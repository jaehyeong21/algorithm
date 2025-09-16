# 1018. 체스판 다시 칠하기
링크

난이도  정답률(_%)
Silver III  50.856

---

## 설계
브루트포스

모든 8×8 구간 검사

입력: N×M 보드 (N,M ≥ 8)

아이디어:

모든 가능한 8×8 체스판을 잘라낸다.

두 가지 패턴 모두 검사 (W 시작, B 시작)

잘못된 칸을 세고 최소값을 갱신한다.

출력: 전체 보드에서 최소로 칠해야 하는 횟수


## 코드 (JAVA)
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1018 {
    static char[][] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int repaintW = checkBoard(i, j, 'W');
                int repaintB = checkBoard(i, j, 'B');
                result = Math.min(result, Math.min(repaintW, repaintB));
            }
        }

        System.out.println(result);
    }

    public static int checkBoard(int x, int y, char start) {
        int count = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                char expected = ((i - x) + (j - y)) % 2 == 0
                        ? start
                        : (start == 'W' ? 'B' : 'W');

                if (arr[i][j] != expected) {
                    count++;
                }
            }
        }
        return count;
    }
}

```
## 정리
브루트포스로 모든 8×8 영역을 검사

checkBoard 함수로 W 시작 / B 시작 각각 비교 

전체 최소값 출력

---

| 항목 | 내 코드 (ms) | 빠른 코드 (ms) |
|:---:|---:|---:|
| 실행 시간 | 0 | 0 |

## 고생한 점
2차원 배열 입력 처리: StringTokenizer 대신 line.charAt(j) 방식으로 한 줄씩 받아야 한다는 점에서 처음 헷갈림.

반복문 범위: 단순히 i < N이 아니라 i <= N-8처럼 조건을 정확히 잡는 부분에서 시간이 걸림.

**두 패턴(W 시작, B 시작)**을 모두 검사해야 한다는 개념을 잡는 데 어려움이 있었음.

checkBoard에서 (i-x) + (j-y)로 상대 좌표를 사용하는 아이디어를 떠올리는 데 시간이 필요했음.

---