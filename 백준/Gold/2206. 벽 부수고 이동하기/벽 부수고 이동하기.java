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

        // map 초기화
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];
//        visited[][][0] = true -> 벽을 부수고 방문(더 이상 벽을 부술 수 없음)
//        visited[][][1] = true -> 벽을 부수지 않고 방문(벽을 부술 수 있음)
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        // 시작 노드 예약
        queue.add(new Node(0, 0, 1, 1));
        visited[0][0][1] = true;

        while (!queue.isEmpty()) {
            // 현재 노드 방문
            Node cur = queue.remove();
            if (cur.y == N - 1 && cur.x == M - 1) {
                System.out.println(cur.distance);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (map[ny][nx] == 0 && !visited[ny][nx][cur.canBreak]) {
                        queue.add(new Node(ny, nx, cur.distance + 1, cur.canBreak));
                        visited[ny][nx][cur.canBreak] = true;
                    }
                    else if(map[ny][nx] == 1 && cur.canBreak == 1 && !visited[ny][nx][0]) {
                        queue.add(new Node(ny, nx, cur.distance + 1, 0));
                        visited[ny][nx][0] = true;
                    }
                }
                
            }
        }
        System.out.println(-1);
    }

    static class Node {
        int y;
        int x;
        int distance;
        int canBreak;
        // canBreak = 0 -> 벽을 부술 수 없음
        // canBreak = 1 -> 벽을 부술 수 있음

        public Node(int y, int x, int distance, int canBreak) {
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.canBreak = canBreak;
        }
    }
}
