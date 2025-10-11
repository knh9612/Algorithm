import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static List<List<Integer>> answer;
    static List<Integer> cur;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cur = new ArrayList<>();
        answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            backtrack(0, 0, i);
        }

        // 값 계산
        int count = 0;
        for (List<Integer> list : answer) {
            int sum = 0;
            for (int i : list) {
                sum += i;
            }
            if (sum == S) count++;
        }
        System.out.println(count);
    }

    static void backtrack(int start, int depth, int k) {
        // 종료 조건
        if (depth == k) {
            answer.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < N; i++) {
            cur.add(arr[i]);
            backtrack(i + 1, depth + 1, k);
            cur.remove(cur.size() - 1); // 마지막 요소 제거
        }
    }
}
