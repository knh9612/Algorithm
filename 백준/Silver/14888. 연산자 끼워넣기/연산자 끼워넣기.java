import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] ops;
    static int min = 1_000_000_000;
    static int max = -1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        ops = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(1, arr[0]);
        System.out.println(max);
        System.out.println(min);

    }

    static void backtrack(int depth, int result) {
        if (result > 1_000_000_000 || result < -1_000_000_000) return;
        // 종료
        if (depth == N) {
            min = Math.min(result, min);
            max = Math.max(result, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] <= 0) continue;

            int nextResult = result;
            if (i == 0) nextResult += arr[depth];
            else if (i == 1) nextResult -= arr[depth];
            else if (i == 2) nextResult *= arr[depth];
            else nextResult /= arr[depth];

            ops[i]--;
            backtrack(depth + 1, nextResult);
            ops[i]++;
        }

    }
}
