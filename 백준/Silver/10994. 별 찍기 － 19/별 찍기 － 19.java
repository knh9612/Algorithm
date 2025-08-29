import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = 4 * (N - 1) + 1;
        String[][] answer = new String[k][k];

        int start = 0;
        for (int i = N; i > 0; i--) {
            star(i, start, answer);
            start += 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (answer[i][j] == null) {
                    sb.append(" ");
                } else {
                    sb.append(answer[i][j]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static void star(int N, int start, String[][] answer) {
        for (int i = start; i < start + 4 * (N - 1) + 1; i++) {
            if (i == start || i == start + 4 * (N - 1) + 1 - 1) {
                for (int j = start; j < start + 4 * (N - 1) + 1; j++) {
                    answer[i][j] = "*";
                }
                continue;
            }

            for (int j = start; j < start + 4 * (N - 1) + 1; j++) {
                if (j == start || j == start + 4 * (N - 1) + 1 - 1) {
                    answer[i][j] = "*";
                }
            }
        }
    }

}
