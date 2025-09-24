import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] trainList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trainList = new int[N + 1][20 + 1];

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());

            if (st.countTokens() == 3) {
                String orderIndex = st.nextToken();
                int i = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                if (orderIndex.equals("1")) {
                    first(i, x);
                }
                if (orderIndex.equals("2")) {
                    second(i, x);
                }

            } else if (st.countTokens() == 2) {
                String orderIndex = st.nextToken();
                int i = Integer.parseInt(st.nextToken());

                if (orderIndex.equals("3")) {
                    third(i);
                }
                if (orderIndex.equals("4")) {
                    fourth(i);
                }
            }
        }

        Set<String> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= 20; j++) {
                sb.append(trainList[i][j]);
            }
            set.add(sb.toString());
        }
        System.out.println(set.size());
    }

    static void first(int i, int x) {
        if (trainList[i][x] == 0) {
            trainList[i][x] = 1;
        }
    }

    static void second(int i, int x) {
        if (trainList[i][x] != 0) {
            trainList[i][x] = 0;
        }
    }

    static void third(int i) {
        if (trainList[i][20] != 0) {
            trainList[i][20] = 0;
        }
        for (int j = 20; j > 1; j--) {
            trainList[i][j] = trainList[i][j - 1];
            
        }
        trainList[i][1] = 0;
    }

    static void fourth(int i) {
        if (trainList[i][1] != 0) {
            trainList[i][1] = 0;
        }
        for (int j = 2; j <= 20; j++) {
            trainList[i][j - 1] = trainList[i][j];

        }
        trainList[i][20] = 0;
    }
}
