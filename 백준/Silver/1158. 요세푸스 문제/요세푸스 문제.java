import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /**
     * 출력 최적화
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        List<Integer> josephus = josephus(q, K);
        sb.append("<");
        for (int i = 0; i < josephus.size(); i++) {
            sb.append(josephus.get(i));
            if (i < josephus.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
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