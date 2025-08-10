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
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];
        // 마지막은 벽을 부술 수 있는지 여부
        // visited[][][0] = true => 이미 벽을 부순 상태에서 방문
        // visited[][][1] = true => 아직 벽을 부수지 않은 상태에서 방문
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        // 시작 노드 예약
        queue.add(new Node(0, 0, 1, true));
        visited[0][0][1] = true;

        while (!queue.isEmpty()) {
            // 현재 노드 방문
            Node cur = queue.remove();
            if (cur.x == N - 1 && cur.y == M - 1) {
                System.out.println(cur.distance);
                return;
            }

            // 상하좌우가 범위 내이고
            // map이 1일 때 canBreak이 0이 아니고
            // visited가 true가 아닐 때만
            // 큐에 추가
            for (Node next : new Node[]{
                    new Node(cur.x + dx[0], cur.y + dy[0], cur.distance + 1, cur.canBreak),
                    new Node(cur.x + dx[1], cur.y + dy[1], cur.distance + 1, cur.canBreak),
                    new Node(cur.x + dx[2], cur.y + dy[2], cur.distance + 1, cur.canBreak),
                    new Node(cur.x + dx[3], cur.y + dy[3], cur.distance + 1, cur.canBreak)
            }) {
                if (0 <= next.x && next.x <= N - 1 && 0 <= next.y && next.y <= M - 1) {
                    int state = next.canBreak ? 1 : 0;
                    // 지나갈 수 있는 길일 때(벽을 부술 수 있는지 없는지에 대한 상태에 해당하는 방문 기록이 없어야 함)
                    if (map[next.x][next.y] == 0 && !visited[next.x][next.y][state]) {
                        queue.add(next);
                        visited[next.x][next.y][state] = true;
                    }

                    // 지나갈 수 없는 길일 때(부술 수 있고, 이미 벽을 부순 상태에 해당하는 방문 기록이 없어야 함)
                    else if (map[next.x][next.y] == 1 && next.canBreak && !visited[next.x][next.y][0]) {
                            next.canBreak = false;
                            queue.add(next);
                            visited[next.x][next.y][0] = true;
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
        boolean canBreak;

        public Node(int x, int y, int distance, boolean canBreak) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.canBreak = canBreak;
        }

    }
}
