import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // graph 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 단방향 간선 설정
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 해킹할 수 있는 컴퓨터
            int B = Integer.parseInt(st.nextToken()); // 컴퓨터 번호

            graph.get(B).add(A);
        }

        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            result[i] = bfs(i);
        }

        // 최댓값 찾기
        int max = result[1];
        for (int i = 2; i <= N; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                answer.add(i);
            }
        }

        Collections.sort(answer);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        // 현재 노드 예약
        queue.add(start);
        visited[start] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            // 현재 노드 방문
            int cur = queue.remove();

            // 다음 노드 탐색
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        return count;
    }

}
