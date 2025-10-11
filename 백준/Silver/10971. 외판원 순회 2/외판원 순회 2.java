import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] graph;
    static boolean[] visited;
    static int minCost = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[1] = true;
        backtrack(1, 1, 0, 1);
        System.out.println(minCost);
    }

    static void backtrack(int start, int cur, int cost, int depth) {
        // 종료 조건
        if (depth == N) {
            if (graph[cur][start] == 0) return;
            minCost = Math.min(minCost, cost + graph[cur][start]);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] || graph[cur][i] == 0) continue;
            if (cost + graph[cur][i] > minCost) continue;

            visited[i] = true;
            backtrack(start, i, cost + graph[cur][i], depth + 1);
            visited[i] = false;

        }
    }
}
