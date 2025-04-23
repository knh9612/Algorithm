import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == 1) {
            System.out.println("<1>");
            return;
        }

        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        List<Integer> jose = josephus(q, K);
        for (int i = 0; i < jose.size(); i++) {
            if (i == 0) {
                System.out.print("<" + jose.get(i));
            } else if (i != jose.size() - 1) {
                System.out.print(", " + jose.get(i));
            } else {
                System.out.print(", " + jose.get(i) + ">");
            }
        }
    }

    public static List<Integer> josephus(Deque<Integer> q, int k) {
        List<Integer> result = new ArrayList<>();
        int count = 1;
        while (!q.isEmpty()) {
            if (count % k != 0) {
                q.offer(q.poll());
            } else {
                result.add(q.poll());
            }
            count++;
        }
        return result;
    }

}