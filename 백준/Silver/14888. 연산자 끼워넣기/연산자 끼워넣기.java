import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static List<Integer> ops;
    static boolean[] visited;
    static List<List<Integer>> opsP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ops = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int op = Integer.parseInt(st.nextToken());
            for (int j = 0; j < op; j++) {
                if (i == 0) ops.add(0);
                else if (i == 1) ops.add(1);
                else if (i == 2) ops.add(2);
                else ops.add(3);
            }
        }

        visited = new boolean[ops.size()];
        opsP = new ArrayList<>();
        backtrack(0, new ArrayList<>());

        int max = -1_000_000_000;
        int min = 1_000_000_000;

        for (List<Integer> list : opsP) {
            int result = arr[0];
            for (int i = 0; i < list.size(); i++) {
                int op = list.get(i);
                if (op == 0) result += arr[i + 1];
                else if (op == 1) result -= arr[i + 1];
                else if (op == 2) result *= arr[i + 1];
                else result /= arr[i + 1];
                if (result > 1_000_000_000 || result < -1_000_000_000) break;
            }
            max = Math.max(result, max);
            min = Math.min(result, min);
        }
        System.out.println(max);
        System.out.println(min);
    }

    static void backtrack(int depth, List<Integer> cur) {
        if (depth == ops.size()) {
            opsP.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < ops.size(); i++) {
            if (visited[i]) continue;

            visited[i] = true;
            cur.add(ops.get(i));
            backtrack(depth + 1, cur);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
