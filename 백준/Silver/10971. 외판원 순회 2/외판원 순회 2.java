import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] graph;
    static int[] answer;
    static boolean[] visited;
    static int minCost = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        answer = new int[N];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0);
        System.out.println(minCost);
    }

    static void backtrack(int depth) {
        // 종료 조건
        if (depth == N) {
            int cost = 0;
            // 거리 계산
            for (int i = 0; i < N - 1; i++) {
                if (graph[answer[i]][answer[i + 1]] == 0) return;
                cost += graph[answer[i]][answer[i + 1]];
            }

            if (graph[answer[N - 1]][answer[0]]== 0) return;
            cost += graph[answer[N - 1]][answer[0]];
            minCost = Math.min(minCost, cost);

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            answer[depth] = i;
            backtrack(depth + 1);
            visited[i] = false;

        }
    }
}
