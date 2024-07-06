import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int[] distance;
	static int k;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		if (n == k) {
			System.out.println(0);
		}
		
		visited = new boolean[100_001];
		distance = new int[100_001];

		bfs(n);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
 		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i : new int[] { now - 1, now + 1, now * 2 }) {
				if (0 <= i && i <= 100_000 && !visited[i]) {
					visited[i] = true;
					distance[i] = distance[now] + 1;
					q.add(i);
					if (i == k) {
						System.out.println(distance[i]);
						return;
					}
					
				}
			}
		}
	}
}