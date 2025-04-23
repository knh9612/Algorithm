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

        List<Integer> josephus = optimizedJosephus(q, K);
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

    /**
     * 요세푸스 순열 메서드 최적화.
     */
    public static List<Integer> optimizedJosephus(Deque<Integer> q, int k) {
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            // 매번 (k–1)번이 아니라 "(k–1) % 현재크기"번만 회전
            int skip = (k - 1) % q.size();    // 실제로 회전해야 할 횟수
            for (int i = 0; i < skip; i++) {
                q.offer(q.poll());
            }
            // 회전하고 무조건 poll()을 해주기 때문에 while문을 벗어나게 되므로 무한루프가 발생하지 않음.
            result.add(q.poll());
        }
        return result;
    }

}