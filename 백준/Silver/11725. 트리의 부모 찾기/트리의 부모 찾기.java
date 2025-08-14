import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static Map<Integer, Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 간선 설정
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        answer = new HashMap<>();
        visited = new boolean[N + 1];
        dfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(answer.get(i));
        }

    }

    static void dfs(int cur) {
        // 현재 노드 방문
        visited[cur] = true;

        // 다음 노드 예약
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                answer.put(next, cur);
                dfs(next);
            }
        }
    }
}
