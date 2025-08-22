import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] bulbList = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bulbList[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) first(bulbList, b, c);
            else if (a == 2) second(bulbList, b, c);
            else if (a == 3) third(bulbList, b, c);
            else fourth(bulbList, b, c);
        }

        for (int i : bulbList) {
            System.out.print(i + " ");
        }
        
    }

    static void first(int[] array, int i, int x) {
        array[i - 1] = x;
    }

    static void second(int[] array, int l, int r) {
        for (int i = l - 1; i <= r - 1; i++) {
            array[i] = (array[i] == 1 ? 0 : 1);
        }
    }

    static void third(int[] array, int l, int r) {
        for (int i = l - 1; i <= r - 1; i++) {
            array[i] = 0;
        }
    }

    static void fourth(int[] array, int l, int r) {
        for (int i = l - 1; i <= r - 1; i++) {
            array[i] = 1;
        }
    }
}
