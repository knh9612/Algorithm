import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        int MAX = 1000;

        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[MAX + 1][MAX + 1];

        // 시작 노드 예약
        queue.add(new Node(1, 0, 0));
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            // 현재 노드 방문
            Node cur = queue.remove();
            if (cur.screen == S) {
                System.out.println(cur.time);
                return;
            }

            // 다음 노드 예약
            if (!visited[cur.screen][cur.screen]) {
                queue.add(new Node(cur.screen, cur.screen, cur.time + 1));
                visited[cur.screen][cur.screen] = true;

            }
            if (0 <= cur.screen + cur.clipboard && cur.screen + cur.clipboard <= MAX && !visited[cur.screen + cur.clipboard][cur.clipboard]) {
                queue.add(new Node(cur.screen + cur.clipboard, cur.clipboard, cur.time + 1));
                visited[cur.screen + cur.clipboard][cur.clipboard] = true;

            }
            if (0 <= cur.screen - 1 && cur.screen - 1 <= MAX && !visited[cur.screen - 1][cur.clipboard]) {
                queue.add(new Node(cur.screen - 1, cur.clipboard, cur.time + 1));
                visited[cur.screen - 1][cur.clipboard] = true;
            }
        }

    }

    static class Node {
        int screen;
        int clipboard;
        int time;

        public Node(int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }
}
