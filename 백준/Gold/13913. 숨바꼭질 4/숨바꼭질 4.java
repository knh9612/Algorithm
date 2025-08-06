import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
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
        int[] minTime = new int[MAX + 1];
        int[] preVal = new int[MAX + 1];

        // 시작 노드 예약
        queue.add(N);
        visited[N] = true;
        preVal[N] = -1;

        while (!queue.isEmpty()) {
            // 현재 노드 방문
            int cur = queue.remove();

            if (cur == K) {
                Deque<Integer> stack = new ArrayDeque<>();
                for (int i = K; i != -1; i = preVal[i]) {
                    stack.push(i);
                }
                System.out.println(minTime[K]);
                for (int i : stack) {
                    System.out.print(i + " ");
                }

            }

            // 다음 노드 예약
            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (0 <= next && next <= MAX && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    minTime[next] = minTime[cur] + 1;
                    preVal[next] = cur;
                }
            }

        }
    }

}
