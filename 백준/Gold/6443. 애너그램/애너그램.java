import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[] arr;
    static char[] answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            arr = new char[line.length()];
            answer = new char[line.length()];
            visited = new boolean[line.length()];

            for (int j = 0; j < line.length(); j++) {
                arr[j] = line.charAt(j);
            }
            Arrays.sort(arr);
            backtrack(0);
        }
        System.out.println(sb);
    }

    static void backtrack(int depth) {
        if (depth == arr.length) {
            for (char c : answer) sb.append(c);
            sb.append("\n");
            return;
        }

        char prev = '!';
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            if (prev == arr[i]) continue;
            prev = arr[i];
            visited[i] = true;
            answer[depth] = arr[i];
            backtrack(depth + 1);
            visited[i] = false;
        }
    }
}
