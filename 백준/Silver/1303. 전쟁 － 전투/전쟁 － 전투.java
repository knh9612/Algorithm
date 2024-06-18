import java.io.*;
import java.util.*;

// dfs를 2번 해야 하나??
// 일단 이렇게 풀고 다른 풀이 ㄱㄱ
public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visitedWhite;
	static boolean[][] visitedBlue;
	static int powerWhite;
	static int powerBlue;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visitedWhite = new boolean[M][N];
		visitedBlue = new boolean[M][N];
		
		for (int y = 0; y < M; y++) {
			String[] str = br.readLine().split("");
			for (int x = 0; x < N; x++) {
				int k = 0;
				if (str[x].equals("W")) k = 0;
				else if (str[x].equals("B")) k = 1;
				map[y][x] = k;
			}
		}

		int white = 0;
		int blue = 0;
		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] == 0 && !visitedWhite[y][x]) {
					powerWhite = 0;
					dfs(y, x, 0);
					white += powerWhite * powerWhite;
				}
				if (map[y][x] == 1 && !visitedBlue[y][x]) {
					powerBlue = 0;
					dfs(y, x, 1);
					blue += powerBlue * powerBlue;
				}
			}
		}
		System.out.println(white + " " + blue);
	}
	
	static void dfs(int y, int x, int k) {
		if (k == 0) {
			visitedWhite[y][x] = true;
			powerWhite++;
		}
		else {
			visitedBlue[y][x] = true;
			powerBlue++;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (k == 0 && map[ny][nx] == 0 && !visitedWhite[ny][nx]) dfs(ny, nx, 0);
				if (k == 1 && map[ny][nx] == 1 && !visitedBlue[ny][nx]) dfs(ny, nx, 1);
			}
		}
	}
	
	
	
}