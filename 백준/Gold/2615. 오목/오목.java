import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map = new int[19][19];

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {0, 1, 1, 1};
        int[] dy = {1, -1, 0, 1};

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {

                if (map[i][j] != 0) {
                    // 현재 노드 방문
                    int status = map[i][j]; // 현재 무슨 색의 돌인지 파악

                    // 다음 노드 탐색 (8방향 중 4개만)
                    for (int k = 0; k < 4; k++) {

                        int count = 1; // 현재 연속된 돌의 개수를 파악: 기본 값은 1

                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        while (0 <= nx && nx < 19 && 0 <= ny && ny < 19 && map[nx][ny] == status) {
                            count++;
                            nx += dx[k];
                            ny += dy[k];

                        }
                        if (count == 5) {
                            // 같은 진행 방향을 탐색 후 6알 이상인지 파악
                            if (0 <= i - dx[k] && i - dx[k] < 19 && 0 <= j - dy[k] && j - dy[k] < 19 && map[i - dx[k]][j - dy[k]] == status) continue;

                            // 5알이 맞으면 바둑알의 색상(status),
                            System.out.println(status);
                            // 가장 왼쪽 위의 좌표를 출력(방향만 알면 이건 쉬울 듯)
                            // 방향에 따라 분기처리
                            if (k == 0) {
                                System.out.println((i + 1) + " " + (j + 1));

                            } else if (k == 1) {
                                System.out.println((nx - dx[k] + 1) + " " + (ny - dy[k] + 1));

                            } else if (k == 2) {
                                System.out.println((i + 1) + " " + (j + 1));

                            } else {
                                System.out.println((i + 1) + " " + (j + 1));

                            }
                            return;

                        }

                    }
                }
            }
        }
        System.out.println(0);

    }

}
