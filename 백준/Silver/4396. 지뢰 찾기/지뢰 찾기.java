import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] mineMap = new String[n][n];
        String[][] game = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");

            for (int j = 0; j < n; j++) {
                mineMap[i][j] = line[j];
            }
        }
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");

            for (int j = 0; j < n; j++) {
                game[i][j] = line[j];
            }
        }

        int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};

        boolean mine = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game[i][j].equals("x") && mineMap[i][j].equals("*")) {
                    mine = true;

                } else if (game[i][j].equals("x")) {
                    int count = 0;
                    for (int k = 0; k < 8; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if (0 <= ny && ny < n && 0 <= nx && nx < n && mineMap[ny][nx].equals("*")) {
                            count++;
                        }
                    }
                    game[i][j] = String.valueOf(count);

                }
            }
        }

        if (mine) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mineMap[i][j].equals("*")) {
                        game[i][j] = "*";        
                    }
                }
                
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(game[i][j]);
            }
            System.out.println();
        }

    }
}
