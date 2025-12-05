import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String[] arr;
    static boolean[] visited;
    static List<Integer> list;
    static String max = "";
    static String min = "~";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new String[N];


        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }

        visited = new boolean[10];
        list = new ArrayList<>();

        dfs(0);

        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int depth) {
        // N+1개 선택 완료 후 결과 저장
        if (depth == N + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i : list) sb.append(i);
            String result = sb.toString();
            if (max.compareTo(result) < 0) max = result;
            if (min.compareTo(result) > 0) min = result;

            return;

        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);

                if (depth == 0 || validate(depth)) {
                    dfs(depth + 1);
                }

                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }


    static boolean validate(int depth) {
        int pre = list.get(depth - 1);
        int cur = list.get(depth);
        String operation = arr[depth - 1];

        if (operation.equals("<")) return pre < cur;
        else return pre > cur;
    }
}
