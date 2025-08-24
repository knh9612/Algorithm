import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

         graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        visited = new boolean[N + 1];
        answer = new int[N + 1];

        dfs(1);
        for (int i = 2; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

    static void dfs(int cur) {
        visited[cur] = true;

        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                answer[next] = cur;
                dfs(next);
            }
        }
    }
}
