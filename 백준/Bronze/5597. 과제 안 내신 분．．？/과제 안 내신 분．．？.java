import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[31];
        for (int i = 0; i < 28; i++) {
            int k = Integer.parseInt(br.readLine());
            arr[k] = 1;
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            if (arr[i] == 0) {
                answer.add(i);
            }
        }

        Collections.sort(answer);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}
