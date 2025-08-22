import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[31];
        for (int i = 0; i < 28; i++) {
            int k = Integer.parseInt(br.readLine());
            arr[k] = 1;
        }

        int[] answer = new int[2];
        int count = 0;
        for (int i = 1; i <= 30; i++) {
            if (arr[i] == 0) {
                answer[count] = i;
                count++;
            }
        }

        Arrays.sort(answer);
        for (int i : answer) {
            System.out.println(i);
        }

    }
}
