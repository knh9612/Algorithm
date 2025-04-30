import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<String> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.startsWith("push_front")) {
                String[] split = command.split(" ");
                dq.addFirst(split[1]);
                continue;
            }

            if (command.startsWith("push_back")) {
                String[] split = command.split(" ");
                dq.addLast(split[1]);
                continue;
            }

            switch (command) {
                case "pop_front":
                    sb.append(!dq.isEmpty() ? dq.pollFirst() + "\n" : -1 + "\n");
                    break;

                case "pop_back":
                    sb.append(!dq.isEmpty() ? dq.pollLast() + "\n" : -1 + "\n");
                    break;

                case "size":
                    sb.append(dq.size() + "\n");
                    break;

                case "empty":
                    sb.append(dq.isEmpty() ? 1 + "\n" : 0 + "\n");
                    break;

                case "front":
                    sb.append(!dq.isEmpty() ? dq.peekFirst() + "\n" : -1 + "\n");
                    break;

                case "back":
                    sb.append(!dq.isEmpty() ? dq.peekLast() + "\n" : -1 + "\n");
                    break;
            }
        }
        br.close();
        System.out.println(sb);
    }
}