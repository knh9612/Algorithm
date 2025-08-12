import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        // graph 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        // 단방향 간선 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        List<Integer> answer = new ArrayList<>();

        // 시작 노드 예약
        queue.add(X);
        visited[X] = true;
        distance[X] = 0;

        while (!queue.isEmpty()) {
            // 현재 노드 방문
            int cur = queue.remove();
            if (distance[cur] == K) {
                answer.add(cur);
                // 추가 노드는 최단 거리가 아니므로 통과
                continue;
            }

            // 다음 노드 예약
            for (int next : graph.get(cur)) {
                if (1 <= next && next <= N && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    distance[next] = distance[cur] + 1;
                }
            }
        }

        if (answer.isEmpty()) {
            System.out.println(-1);
            return;
        }
        
        Collections.sort(answer);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}
