import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Node> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dq.offerFirst(new Node(i, Integer.parseInt(st.nextToken())));
        }
        // 1 <= N <= 1_000
        Node node = dq.pollLast();
        sb.append(node.key + " ");
        if (dq.isEmpty()) {
            System.out.println(1);
            return;
        }

        while (!dq.isEmpty()) {
            int card = node.value;
            if (card > 0) {
                for (int i = 0; i < card - 1; i++) {
                    dq.offerFirst(dq.pollLast());
                }
                node = dq.pollLast();
            } else {
                for (int i = 0; i < -card - 1; i++) {
                    dq.offerLast(dq.pollFirst());
                }
                node = dq.pollFirst();
            }
            sb.append(node.key).append(" ");
        }
        System.out.println(sb);
    }

    // 엥 근데 Getter()가 없어도 접근 가능하나..?
    static class Node {
        private final int key;
        private final int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}