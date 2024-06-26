import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int x = 0; x < N; x++) {
			String[] str = new String[N];
			str = br.readLine().split("");
			for (int y = 0; y < M; y++) {
				map[x][y] = Integer.parseInt(str[y]);
			}
		}
		bfs(0,0);
		System.out.println(map[N-1][M-1]);
	}
	
	static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>(); // 큐 안에 int[]가 들어감
		q.offer(new int[] {i, j}); // int[]이 들어가기 때문에 `new int[] {i, j}`
		visited[i][j] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll(); // 큐에 있는 놈 하나 빼서
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if (0<=x && x<N && 0<=y && y<M && map[x][y]!=0 & !visited[x][y]) {
					visited[x][y] = true;
					map[x][y] = map[now[0]][now[1]] + 1; // depth 업데이트
					q.add(new int[] {x, y});
				}
			}
		}
	}
}