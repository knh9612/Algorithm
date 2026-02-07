import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        sb = new StringBuilder();
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        sb.append(cur).append(" ");

        Collections.sort(graph.get(cur)); // 작은 노드부터 탐색해야 하기 때문에 정렬

        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            Collections.sort(graph.get(cur));

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    sb.append(next).append(" ");
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
