import java.io.*;
import java.util.*;

// depth를 전역 변수로 설정을 했고, dfs 돌 때 마다 ++하게 해서 잘못됐음
// 파라미터로 depth+1 해서 넘겨서
// 연결되면서 dfs 돌 때 마다 ++하게 했음
public class Main {
	static int N, M;
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N];
		visited = new boolean[N];
		// 초기화 시켜 주면서
		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			// 방향 없음. 어차피 visited 있으니 ㄱㅊ
			A[s].add(e);
			A[e].add(s);
		}
		
		answer = 0;
		for (int i = 0; i < N; i++) {
			dfs(i, 1);
		}
		System.out.println(answer);
		
	}
	
	static void dfs(int v, int depth) {
		visited[v] = true;
		if (depth >= 5) {
			answer = 1;
			return;
		}
		
		for (int i : A[v]) {
			if (!visited[i]) dfs(i, depth+1);
		}
		visited[v] = false;
	}
}