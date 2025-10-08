import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int N, M;
    static Set<Integer> arr;
    static int[] answer;
    static ArrayList<Integer> array;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new TreeSet<>();
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        array = new ArrayList<>(arr);

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i : answer) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            answer[depth] = array.get(i);
            dfs(depth + 1);
        }
    }
}
