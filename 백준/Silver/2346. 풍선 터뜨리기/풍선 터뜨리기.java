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
            dq.offerLast(new Node(i, Integer.parseInt(st.nextToken())));
        }

        Node node = dq.pollFirst();
        sb.append(node.key).append(" ");

        while (!dq.isEmpty()) {
            int card = node.value;
            if (card > 0) {
                for (int i = 0; i < card - 1; i++) {
                    dq.offerLast(dq.pollFirst());
                }
                node = dq.pollFirst();
            } else {
                for (int i = 0; i < -card - 1; i++) {
                    dq.offerFirst(dq.pollLast());
                }
                node = dq.pollLast();
            }
            sb.append(node.key).append(" ");
        }
        br.close();
        System.out.println(sb);
    }

    static class Node {
        private final int key;
        private final int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}