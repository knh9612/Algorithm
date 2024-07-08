import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static boolean[] visited;
	static int[] distance;
	static int[] previous;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		if (n == k) {
			System.out.println(0);
			System.out.println(k);
			return;
		}

		visited = new boolean[100_001];
		distance = new int[100_001];
		previous = new int[100_001];

		bfs(n);
		System.out.println(distance[k]);
		printPath(k);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		distance[start] = 0;
		previous[start] = -1; // 시작 위치는 이전 위치가 없으므로 -1

		while (!q.isEmpty()) {
			int now = q.poll();
			int[] A = { now - 1, now + 1, now * 2 };

			for (int next : A) {
				if (0 <= next && next <= 100_000 && !visited[next]) {
					q.add(next);
					visited[next] = true;
					distance[next] = distance[now] + 1;
					previous[next] = now; // 다음 위치의 이전 위치를 현재로 설정

					if (next == k) {
						return;
					}
				}
			}
		}
	}

	// 출력 성능 문제가 아니라 위에서 system.out이 아니라 system.err를 사용;;;
	
	// 여기서 previous 배열에 전 위치를 담고 스택을 사용하여 경로를 출력하는 법 숙지하도록!
	private static void printPath(int end) throws Exception {
		Stack<Integer> s = new Stack<>(); // 경로 탐색은 스택!

		for (int now = end; now != -1; now = previous[now]) {
			s.push(now);
		}

		StringBuilder sb = new StringBuilder();
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}
}