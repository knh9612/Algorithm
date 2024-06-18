import java.io.*;
import java.util.*;

// dfs를 2번 해야 하나??
// 일단 이렇게 풀고 다른 풀이 ㄱㄱ
public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited; // 얘를 2개를 만들어서 했었는데 그럴 필요 ㄴㄴㄴ
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
		visited = new boolean[M][N];
		
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
				if (map[y][x] == 0 && !visited[y][x]) {
					powerWhite = 0;
					dfs(y, x, 0);
					white += powerWhite * powerWhite;
				}
				if (map[y][x] == 1 && !visited[y][x]) {
					powerBlue = 0;
					dfs(y, x, 1);
					blue += powerBlue * powerBlue;
				}
			}
		}
		System.out.println(white + " " + blue);
	}
	
	static void dfs(int y, int x, int k) {
			visited[y][x] = true;
			if (k == 0) powerWhite++;
			else if (k == 1) powerBlue++;
	
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < M && map[ny][nx] == k && !visited[ny][nx]) {
				dfs(ny, nx, k);
			}
		}
	}
}