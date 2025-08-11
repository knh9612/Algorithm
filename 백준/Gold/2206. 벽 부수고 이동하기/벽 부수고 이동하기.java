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
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // map 초기화
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];
        // visited[][][0] = true; 이미 벽을 부수고 방문
        // visited[][][1] = true; 아직 벽을 부수지 않고 방문

        // 시작 노드 예약
        queue.add(new Node(0, 0, 1, 1));
        visited[0][0][1] = true;

        while (!queue.isEmpty()) {
            // 현재 노드 방문
            Node cur = queue.remove();
            if (cur.x == N - 1 && cur.y == M - 1) {
                System.out.println(cur.distance);
                return;
            }

            // 다음 노드 예약
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    // 다음 칸이 0일 때
                    // 벽을 부술 수 있는지 없는지 여부와 상관 없이 현재 상태에 해당하는 배열 방문 처리
                    if (map[nx][ny] == 0 && !visited[nx][ny][cur.canBreak]) {
                        queue.add(new Node(nx, ny, cur.distance + 1, cur.canBreak));
                        visited[nx][ny][cur.canBreak] = true;
                    }

                    // 다음 칸이 1일 때
                    // 부술 수 있어야 함(canBreak = 1 && visited[][][0] = false 이어야 부술 수 있음)
                    else if (map[nx][ny] == 1 && cur.canBreak == 1 && !visited[nx][ny][0]) {
                        queue.add(new Node(nx, ny, cur.distance + 1, 0));
                        visited[nx][ny][0] = true;
                        // 부수고 이동하므로 canBreak = 0 && visited[][][0] = true
                    }
                }
            }

        }

        System.out.println(-1);

    }

    static class Node {
        int x;
        int y;
        int distance;
        int canBreak; // 부술 수 있으면 1, 없으면 0

        public Node(int x, int y, int distance, int canBreak) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.canBreak = canBreak;
        }

    }
}
