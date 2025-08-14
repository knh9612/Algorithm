import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[N + 1];
        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 간선 설정
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        answer = new ArrayList<>();

        // dfs 실행
        dfs(V);
        // 출력 및 초기화
        for (int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
        answer = new ArrayList<>();
        visited = new boolean[N + 1];

        // bfs 실행
        bfs(V);
        // 출력
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    static void dfs(int cur) {
        // 현재 노드 방문
        answer.add(cur);
        visited[cur] = true;
        Collections.sort(graph.get(cur));

        // 다음 노드 예약
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        // 초기화
        answer.add(start);
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            // 현재 노드 꺼내서 처리
            int cur = queue.remove();
            Collections.sort(graph.get(cur));

            // 다음 노드 탐색
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    answer.add(next);
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
