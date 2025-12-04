import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> cur;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        visited = new boolean[N];
        cur = new ArrayList<>();

        dfs(0);
        System.out.println(max);
    }

    // 주어진 배열의 순서의 모든 경우의 수
    public static void dfs(int depth) {
        if (depth == N) {
            // 계산 함수 실행
            if (calculate(cur) > max) {
                max = calculate(cur);
                return;
            }
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cur.add(arr[i]);
                dfs(depth + 1);
                visited[i] = false;
                cur.remove(cur.size() - 1);

            }
        }

    }

    // 주어진 계산 하는 함수
    public static int calculate(List<Integer> cur) {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(cur.get(i) - cur.get(i + 1));
        }

        return sum;
    }
}
