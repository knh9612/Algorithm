import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int N = Integer.parseInt(st.nextToken());
	int L = Integer.parseInt(st.nextToken());
	
	st = new StringTokenizer(br.readLine());
	Deque<Node> deq = new LinkedList<>();
	
	for (int i = 0; i < N; i++) {
		// 하나씩 받으면서 그 값을 덱의 마지막 값과 비교한 다음에 넣을 것임
		int now = Integer.parseInt(st.nextToken());
		
		// 덱의 마지막 값이 들어오는 값보다 크면 마지막 값 삭제
		// 계속 반복함으로써 자동 정렬!!!!!!!!1
		while (!deq.isEmpty() && deq.getLast().value > now) {
			deq.removeLast();
		}
		// 이제 now 값 덱에 추가
		deq.addLast(new Node(i, now));
		// 슬라이딩 윈도우의 범위를 벗어나면 덱에서 첫번째 값 삭제
		if (i - deq.getFirst().index >= L) {
			deq.removeFirst();
		}
		bw.write(deq.getFirst().value + " ");
	}
	bw.flush();
	bw.close();
	
	}		

	static class Node {
		int index;
		int value;
		
		Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
}