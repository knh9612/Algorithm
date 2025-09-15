import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] S = new int[1_000_001];
        int[] D = new int[1_000_001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i + 1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            D[i + 1] = Integer.parseInt(st.nextToken());
        }

        int[] P = new int[1_000_001];
        for (int i = 0; i < K; i++) {

            for (int j = 1; j <= N; j++) {
                P[D[j]] = S[j];
            }

            for (int j = 1; j <= N; j++) {
                S[j] = P[j];
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(P[i] + " ");
        }
    }
}
