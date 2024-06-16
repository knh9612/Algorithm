import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] A;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>(); 
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				answer++;
				dfs(i);
			}
		}
		System.out.println(answer);
	}
	static void dfs(int v) {
		if (visited[v]) return; // 이미 방문한 노드면 return
		else visited[v] = true;
		for (int i : A[v]) {
			if (!visited[i]) dfs(i);
		}
	}
	
}