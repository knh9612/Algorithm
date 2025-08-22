import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] array = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cowNum = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());

            array[cowNum - 1].add(location);
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int previousLocation = -1;
            for (int k : array[i]) {
                if (previousLocation != k) {
                    count++;
                }
                previousLocation = k;
            }
        }

        for (ArrayList<Integer> list : array) {
            if (!list.isEmpty()) {
                count--;
            }
        }

        System.out.println(count);

    }


}
