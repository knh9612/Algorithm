import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];
        visited = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                check(Integer.parseInt(st.nextToken()));
                if (isBingo() >= 3) {
                    System.out.println(i * 5 + (j + 1));
                    return;
                }
            }
        }
    }

    static void check(int k) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == k) {
                    visited[i][j] = true;
                }
            }
        }
    }

    static int isBingo() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            boolean isBingo = false;

            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) {
                    isBingo = true;
                } else {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) count++;
        }

        for (int i = 0; i < 5; i++) {
            boolean isBingo = false;

            for (int j = 0; j < 5; j++) {
                if (visited[j][i]) {
                    isBingo = true;
                } else {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) count++;
        }

        boolean isBingo = false;
        for (int i = 0; i < 5; i++) {
            if (visited[i][i]) {
                isBingo = true;
            } else {
                isBingo = false;
                break;
            }
        }
        if (isBingo) count++;

        isBingo = false;
        for (int i = 0; i < 5; i++) {
            if (visited[i][4 - i]) {
                isBingo = true;
            } else {
                isBingo = false;
                break;
            }
        }
        if (isBingo) count++;

        return count;
    }
}
