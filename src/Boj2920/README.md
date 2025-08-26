# 2920. 음계
링크

난이도  정답률(_%)
Bronze II  57.910

---

## 설계
메모이제이션

인접 차이 비교

- 입력: 1~8 사이 정수 8개가 공백으로 주어진다.
- 아이디어:
    - 인접 원소의 차이가 모두 `+1` → `ascending`
    - 인접 원소의 차이가 모두 `-1` → `descending`
    - 그 외 하나라도 다르면 → `mixed`
- 출력은 **모든 입력을 검사한 뒤** 한 번만 한다.


## 코드 (JAVA)
```java
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
```
## 정리

---

| 항목 | 내 코드 (ms) | 빠른 코드 (ms) |
|:---:|---:|---:|
| 실행 시간 | 0 | 0 |

## 고생한 점

---