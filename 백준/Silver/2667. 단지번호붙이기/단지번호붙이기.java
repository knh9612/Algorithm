import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx;
    static int[] dy;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        visited = new boolean[N][N];
        int count = 0;
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count++;
                    answer.add(dfs(i, j));
                }
            }
        }

        System.out.println(count);
        Collections.sort(answer);
        for (int i : answer) {
            System.out.println(i);
        }
        
    }

    static int dfs(int x, int y) {
        // 현재 노드 방문
        visited[x][y] = true;
        int count = 1;

        // 다음 노드 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<= nx && nx < N && 0<= ny && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
                count += dfs(nx, ny);
            }
        }
        return count;
    }

}
