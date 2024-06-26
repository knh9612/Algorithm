import java.io.*;
import java.util.*;

public class Main {
	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int count = 1;
		while (count <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			int answer = 0;
			
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (map[y][x]!=0 && !visited[y][x]) {
						dfs(x,y);
						answer++;
					}
				}
			}
			System.out.println(answer);
			count++;
		}
	}
	static void dfs(int x, int y) {
		visited[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0<=nx && nx<M && 0<=ny && ny<N && map[ny][nx]!=0 && !visited[ny][nx]) {
				dfs(nx, ny);
			}
		}
	}
}