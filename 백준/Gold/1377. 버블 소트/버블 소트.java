import java.io.*;
import java.util.*;

// 버블 정렬의 swap이 한 번도 일어나지 않은 루프가 언제인지 알아내는 문제
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] A = new Node[N];
		for(int i = 0; i < N; i++) {
			A[i] = new Node(i, Integer.parseInt(br.readLine()));
		}
		Arrays.sort(A); // Comparable를 implements해서 compareTo를 오버라이드 했기 때문에,
						// value를 기준으로 오름차순 정렬
		// 이제 전과 후의 index 값을 비교하면서 최댓값 찾기
		int max = 0;
		for (int i = 0; i < N; i++) {
			int k = A[i].index - i;
			if (max < k) {
				max = k;
			}
		}
		System.out.println(max+1);
		
	}
	
	public static class Node implements Comparable<Node> {
		int index;
		int value;	
		
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
		
		@Override
		public int compareTo(Node node) {
			return this.value - node.value; // value를 기준으로 오름차순 정렬
		}
	}
}