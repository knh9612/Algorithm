import java.io.*;
import java.util.*;

public class Main {
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Node>[] A;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		A = new ArrayList[N+1];
		// 초기화 시켜주고
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			while (true) {
				int e = Integer.parseInt(st.nextToken());
				if (e == -1) break;
				int v = Integer.parseInt(st.nextToken());
				A[s].add(new Node(e, v));
			}
		}
		// 일단 여기까지 다 받았음
		distance = new int[N+1];
		visited = new boolean[N+1];
		bfs(1);
		
		int max = 1;
		for (int i = 2; i <= N; i++) {
			if (distance[i] > distance[max]) max = i; // 값 말고 시작점을 찾아야 하므로 i를 max에 대입
		}
		// bfs 다시 하기 전 초기화
		distance = new int[N+1];
		visited = new boolean[N+1];
		bfs(max);
		Arrays.sort(distance);
		System.out.println(distance[N]);
	}
	
	private static void bfs(int index) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(index);
		visited[index] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			for (Node i : A[now]) {
				int e = i.end;
				int v = i.value;
				if (!visited[e]) {
					q.add(e);
					visited[e] = true;
					distance[e] = distance[now] + v;
				}
			}
		}
	}
}

class Node {
	int end;
	int value;
	
	Node(int end, int value) {
		this.end = end;
		this.value = value;
	}
}