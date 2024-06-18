import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int size;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int y = 0; y < N; y++) {
			String[] str = br.readLine().split("");
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(str[x]); 
			}
		}
		
		List<Integer> areaSizes = new ArrayList<>();
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] == 1 && !visited[y][x]) {
					size = 0;
					dfs(y, x);
					areaSizes.add(size);
				}
			}
		}
		Collections.sort(areaSizes);
		System.out.println(areaSizes.size());
		for (int i : areaSizes) {
			System.out.println(i);
		}

	}
	
	static void dfs (int y, int x) {
		visited[y][x] = true;
		size++;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[ny][nx] && map[ny][nx] == 1) {
				dfs(ny, nx);
			}
		}
	}
}