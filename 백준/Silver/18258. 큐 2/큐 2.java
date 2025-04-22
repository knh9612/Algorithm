import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<String> arr = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            arr.add(br.readLine());
        }

        for (String s : arr) {
            if (s.startsWith("push")) {
                String[] split = s.split(" ");
                q.offer(Integer.parseInt(split[1]));

            } else if (s.equals("pop")) {
                if (q.isEmpty()) {
                    sb.append(-1)
                            .append("\n");
                } else {
                    sb.append(q.poll())
                            .append("\n");
                }

            } else if (s.equals("size")) {
                sb.append(q.size())
                        .append("\n");

            } else if (s.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append(1)
                            .append("\n");
                } else {
                    sb.append(0)
                            .append("\n");
                }

            } else if (s.equals("front")) {
                if (q.isEmpty()) {
                    sb.append(-1)
                            .append("\n");
                } else {
                    sb.append(q.getFirst())
                            .append("\n");
                }

            } else if (s.equals("back")) {
                if (q.isEmpty()) {
                    sb.append(-1)
                            .append("\n");
                } else {
                    sb.append(q.getLast())
                            .append("\n");
                }
            }

        }
        System.out.print(sb.toString());

    }

}