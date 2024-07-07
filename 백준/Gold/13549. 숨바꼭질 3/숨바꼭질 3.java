import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static boolean[] visited;
	static int[] times;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		if (n == k) {
			System.out.println(0);
			return;
		}

		visited = new boolean[100_001];
		times = new int[100_001];

		dfs(n);

		System.out.println(times[k]);
	}

	// 순간이동을 할 때는 0초 소요이기 때문에
	// 큐가 아니라 데큐를 쓰고
	// 순간이동은 앞에 넣고, 그냥 이동은 뒤에 넣기
	// 이러면 순간이동을 먼저 하니께 시간 가장 빠름!
	private static void dfs(int start) {
		Deque<Integer> dq = new LinkedList<>();
		dq.add(start);
		visited[start] = true;
		times[start] = 0;

		while (!dq.isEmpty()) {
			int now = dq.poll();
			int[] A = { now - 1, now + 1, now * 2 };
			for (int next : A) {
				if (0 <= next && next <= 100_000 && !visited[next]) {
					if (next == now * 2) {
						dq.addFirst(next);
						visited[next] = true;
						times[next] = times[now];

					} else {
						dq.addLast(next);
						visited[next] = true;
						times[next] = times[now] + 1;
					}
				}
			}

		}
	}
}