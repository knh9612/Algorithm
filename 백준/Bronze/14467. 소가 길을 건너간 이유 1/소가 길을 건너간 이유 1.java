import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] location = new int[10];
        Arrays.fill(location, -1);

        int count = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            if (location[n - 1] == -1) {
                location[n - 1] = l;

            } else if (location[n - 1] != l) {
                location[n - 1] = l;
                count++;
            }
        }
        System.out.println(count);
    }
}
