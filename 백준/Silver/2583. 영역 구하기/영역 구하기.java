import java.io.*;
import java.util.*;

public class Main {
	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int size;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// 직사각형 1로 채움
			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					map[y][x] = 1;
				}
			}
		}
		List<Integer> areaSizes = new ArrayList<>();
		// 자자 이제 지도 전체 돌면서 탐색
		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] == 0 && !visited[y][x]) {
					size = 0; // dfs로 탐색하기 전에 size 초기화!
					dfs(y, x);
					areaSizes.add(size);
				}
			}
		}
		Collections.sort(areaSizes);
		System.out.println(areaSizes.size());
		for (int i : areaSizes) {
			System.out.print(i + " ");
		}
	}
	
	static void dfs(int y, int x) {
		// 일단 방문처리 해야하고
		visited[y][x] = true; // 예외는 없나? 근데 어차피 밑에서 직사각형 영역이 아니고, 방문하지 않은 것들만 탐색해서 상관 없을 듯?
		size++; // 방문한 곳도 포함되므로 영역에 추가
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// map 범위를 벗어나지 않고, 직사각형 영역이 아니고, 방문하지 않은 것들만 탐색
			if (0 <= nx && nx < N && 0 <= ny && ny < M && map[ny][nx] == 0 && !visited[ny][nx]) {
				dfs(ny, nx);
			}
		}
	}
}