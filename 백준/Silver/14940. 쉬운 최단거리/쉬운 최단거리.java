import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] graph;
    static int[][] answer;
    static int[] start;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] == 0) {
                    answer[i][j] = 0;

                } else if (graph[i][j] == 2) {
                    start = new int[]{i, j};
                }
            }
        }

        bfs(start);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void bfs(int[] start) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        answer[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && answer[nx][ny] == -1 && graph[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    answer[nx][ny] = answer[cur[0]][cur[1]] + 1;
                }
            }
        }
    }
}
