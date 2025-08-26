import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);

        queue.offer(X);
        distance[X] = 0;

        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (distance[cur] == K) {
                answer.add(cur);
                continue;
            }

            for (int next : graph.get(cur)) {
                if (distance[next] == -1) {
                    queue.offer(next);
                    distance[next] = distance[cur] + 1;
                }
            }
        }

        if (answer.isEmpty()) {
            System.out.println(-1);
        }

        Collections.sort(answer);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}
