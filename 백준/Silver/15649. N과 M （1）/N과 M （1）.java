import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(N, M, new ArrayList<>(), visited, answer);
        StringBuilder sb = new StringBuilder();
        for (List<Integer> list : answer) {
            for (int i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void backtrack(int N, int M, List<Integer> curr, boolean[] visited, List<List<Integer>> answer) {
        if (curr.size() == M) {
            answer.add(new ArrayList<>(curr)); // 정답 저장
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                curr.add(i);
                visited[i] = true;
                backtrack(N, M, curr, visited, answer);
                curr.remove(curr.size() - 1); // BackTracking: 원래 상탵로 되돌림
                visited[i] = false;
            }
        }
    }
}
