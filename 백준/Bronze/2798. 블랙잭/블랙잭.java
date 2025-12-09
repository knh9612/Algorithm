import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int max = Integer.MIN_VALUE;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        dfs(0, 0);
        System.out.println(max);

    }

    static void dfs(int depth, int sum) {
        if (depth == 3) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (sum + arr[i] <= M) {
                    dfs(depth + 1, sum + arr[i]);
                }
                visited[i] = false;
            }
        }
    }
}
