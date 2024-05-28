import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		// 덱에 index와 값을 저장해서 값 크기 비교 및 index로 범위 비교
		Deque<Node> deq = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			// 들어오는 값
			int input = Integer.parseInt(st.nextToken());
			// 들어오는 값과 덱의 마지막 값 크기 비교
			// 덱의 값이 더 크면 삭제 -> 들어오는 값이 더 작을 때 까지 삭제
			while (!deq.isEmpty() && deq.getLast().value > input) {
				deq.removeLast();
			}
			// 위의 while문으로 오름차순 정렬 됨ㅇㅇ
			// 이제 들어오는 값 덱에 넣음
			deq.addLast(new Node(i, input));
			// 범위 체크
			// 슬라이딩 윈도우의 범위가 L이내인지 확인 후 범위에 맞게 조절!
			if (i - deq.getFirst().index >= L) {
				deq.removeFirst();
			}
//			System.out.print(deq.getFirst().value + " ");
			bw.write(deq.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
		
	}
	
	static class Node {
		int index;
		int value;
		
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
}