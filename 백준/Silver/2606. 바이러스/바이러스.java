import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= count; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[count + 1];

        // 양방향 간선 설정
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        System.out.println(dfs(1) - 1);

    }

    static int dfs(int cur) {
        // 현재 노드 방문
        visited[cur] = true;

        int count = 1;
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                count += dfs(next);
            }
        }
        return count;
    }
}
