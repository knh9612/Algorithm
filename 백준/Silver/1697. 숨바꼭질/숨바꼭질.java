import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100_001];
        int[] distance = new int[100_001];

        Queue<Integer> queue = new ArrayDeque<>();

        // 시작점 예약
        queue.add(N);
        visited[N] = true;

        while (!queue.isEmpty()) {
            // 현재 노드 방문
            int cur = queue.remove();
            if (cur == K) {
                System.out.println(distance[K]);
            }

            // 다음 노드 예약
            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (0 <= next && next <= 100_000 && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    distance[next] = distance[cur] + 1;
                }
            }
        }
    }

}
