import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int hp = 0;        // 피로도
        int work = 0;     // 일량

        for (int hour = 0; hour < 24; hour++) {
            if (hp + A <= M) {   // 일할 수 있으면
                hp += A;
                work += B;
            } else {             // 아니면 쉼
                hp = Math.max(0, hp - C);
            }
        }

        System.out.println(work);
    }
}
