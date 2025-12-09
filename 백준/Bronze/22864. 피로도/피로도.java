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
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 0));

        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.time == 24) {
                max = Math.max(max, cur.work);
                continue;
            }

            // 일하기
            if (cur.hp + A <= M) {
                queue.offer(new Node(cur.hp + A, cur.work + B, cur.time + 1));
            }

            // 쉬기
            int nextHp = Math.max(0, cur.hp - C);
            queue.offer(new Node(nextHp, cur.work, cur.time + 1));
        }

        System.out.println(max);
    }

    static class Node {
        int hp;
        int work;
        int time;

        public Node(int hp, int work, int time) {
            this.hp = hp;
            this.work = work;
            this.time = time;
        }

    }
}
