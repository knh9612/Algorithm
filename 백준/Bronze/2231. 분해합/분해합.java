import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int start = N - String.valueOf(N).length() * 9;
        for (int i = start; i <= N; i++) {
            int k = i;
            int sum = k;

            while (k != 0) {
                sum += k % 10;
                k /= 10;
            }

            if (sum == N) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
