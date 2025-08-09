import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());

        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[10000][10000];

        // 현재 노드 예약
        queue.add(new Node(1, 0, 0, "0"));
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            // 현재 노드 방문
            Node cur = queue.remove();
            if (cur.screen == S) {
                System.out.println(cur.time);
                return;
            }

            // 다음 노드 예약
            for (Node next : new Node[]{
                    new Node(cur.screen, cur.screen, cur.time + 1, "1"),
                    new Node(cur.screen + cur.clipboard, cur.clipboard, cur.time + 1, "2"),
                    new Node(cur.screen - 1, cur.clipboard, cur.time + 1, "3")
            }) {

                if (next.status.equals("1") && !visited[next.screen][next.clipboard]) {
                    queue.add(next);
                    visited[next.screen][next.clipboard] = true;

                } else if (next.status.equals("2") && next.clipboard > 0 && !visited[next.screen][next.clipboard]) {
                    queue.add(next);
                    visited[next.screen][next.clipboard] = true;

                } else if (next.status.equals("3") && next.screen >= 0 && !visited[next.screen][next.clipboard]) {
                    queue.add(next);
                    visited[next.screen][next.clipboard] = true;
                }
            }
        }
    }
}

class Node {
    int screen;
    int clipboard;
    int time;
    String status;

    public Node(int screen, int clipboard, int time, String status) {
        this.screen = screen;
        this.clipboard = clipboard;
        this.time = time;
        this.status = status;
    }
}
