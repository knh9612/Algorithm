import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dist;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        dist = new int[N][M];

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int row, int column) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, column});
        dist[row][column] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];

            if (cr == N-1 && cc == M-1) {
                return dist[cr][cc];
            }

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                    if (map[nr][nc] == 0 || dist[nr][nc] != 0) continue;

                    queue.offer(new int[]{nr, nc});
                    dist[nr][nc] = dist[cr][cc] + 1;
                }
            }
        }
        return -1;
    }
}
