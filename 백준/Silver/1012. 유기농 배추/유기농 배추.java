import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy;
    static int[] dx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 배추 개수

            // map 초기화
            map = new int[N][M];
            visited = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }

            dy = new int[]{0, 1, 0, -1};
            dx = new int[]{1, 0, -1, 0};
            int count = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        dfs(j, k);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int y, int x) {
        // 현재 노드 방문
        visited[y][x] = true;

        // 다음 노드 탐색
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0 <= ny && ny < N && 0 <= nx && nx < M && map[ny][nx] == 1 && !visited[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }
}
