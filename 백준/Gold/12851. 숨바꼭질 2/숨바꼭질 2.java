import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int[] distance;
	static int[] ways;
	static int n, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		if (n == k) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		
		visited = new boolean[100_001];
		distance = new int[100_001];
		ways = new int[100_001];
		
		dfs(n);
		System.out.println(distance[k]);
		System.out.println(ways[k]);
		
	}
	
	private static void dfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		distance[start] = 0;
		ways[start] = 1;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			int[] A = {now-1, now+1, now*2};
			for (int next : A) {
				if (0<=next && next <=100_000) {
					if (!visited[next]) {
						q.add(next);
						visited[next] = true;
						distance[next] = distance[now] + 1;
						ways[next] += ways[now];
					}
					else if (distance[next] == distance[now] + 1) {
						ways[next] += ways[now];
					}
				}
			}
		}
	}
}