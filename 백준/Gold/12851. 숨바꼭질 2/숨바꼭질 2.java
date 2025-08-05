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
        int MAX = 100_000;

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX + 1];
        int[] minDistance = new int[MAX + 1];
        int[] ways = new int[MAX + 1];

        // 시작점 예약
        queue.add(N);
        visited[N] = true;
        ways[N] = 1;

        while (!queue.isEmpty()) {
            // 현재 노드 방문
            int cur = queue.remove();

            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                // 다음 노드 예약
                if (0 <= next && next <= MAX) {
                    if (!visited[next]) {
                        // 방문하지 않은 곳이라면 예약
                        queue.add(next);
                        visited[next] = true;
                        minDistance[next] = minDistance[cur] + 1;
                        ways[next] = ways[cur];

                    } else if (minDistance[next] == minDistance[cur] + 1) {
                        // 방문한 곳이고, 최단거리라면
                        ways[next] += ways[cur];
                    }
                }
            }
        }

        System.out.println(minDistance[K]);
        System.out.println(ways[K]);
    }
}
