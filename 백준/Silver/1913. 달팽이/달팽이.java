import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        br.close();

        int[][] answer = new int[N][N];
        int x = N / 2;
        int y = N / 2;
        int n = 1;
        answer[x][y] = n;
        int targetX = x + 1;
        int targetY = y + 1;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int dir = 0;
        int count = 1;


        for (int i = 0; i < N * N; i++) {
            for (int r = 0; r < 2; r++) {
                for (int j = 0; j < count; j++) {
                    if (n >= N * N) break;
                    x += dx[dir];
                    y += dy[dir];
                    answer[x][y] = ++n;
                    if (n == K) {
                        targetX = x + 1;
                        targetY = y + 1;
                    }
                }
                dir = (dir + 1) % 4;
            }
            count++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(targetX + " " + targetY);
    }
}
