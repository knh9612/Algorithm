import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int max = 1;
		
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] > max) max = map[y][x];
			}
		}

		int answer = 1;
		for (int depth = 1; depth <= max; depth++) {
			visited = new boolean[N][N];
			int safeArea = 0;
			
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if(map[y][x] > depth && !visited[y][x]) {
						dfs(x, y, depth);
						safeArea++;
					}
				}
			}
            if (safeArea > answer) {
                answer = safeArea;
            }
		}
		System.out.println(answer);
	}
	
	static void dfs(int x, int y, int depth) {
		visited[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < N && map[ny][nx] > depth && !visited[ny][nx]) {
				dfs(nx, ny, depth);
			}
		}
	}
}