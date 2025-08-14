import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
        static List<List<Integer>> graph;
        static boolean[] visited ;
        static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 100
        int v = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        visited = new boolean[n];

        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 간선 설정
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a - 1).add(b - 1);
            graph.get(b - 1).add(a - 1);
        }

        dfs(0);
        System.out.println(count);

    }

    static void dfs(int cur) {
        // 현재 노드 방문
        visited[cur] = true;

        // 다음 노드 예약
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                count++;
                dfs(next);
            }
        }

    }
}
