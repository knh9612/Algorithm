import java.io.*;
import java.util.*;

// A의 오큰수
// A의 오른쪽에 있으면서 A보다 큰 수 중 가장 왼쪽에 있는 수
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] RLN = new int[N]; // 오큰수 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		// 스택에는 index 값을 넣을 것임 -> 이렇게 함으로써 시간 복잡도 해결
		// 들어오는 값(A[i])의 index 값을 스택에 계속 푸쉬할 것임
		
		// # 핵심
		// 근데 들어오는 값(A[i])이 top보다 크다면
		// 정답배열[top값]에 A[i]를 넣을 것임
		// top < A[i]이면, A[i]가 A[top]값의 오큰수이기 때문 -> 이래서 스택에 index 저장
	
		// pop으로 A[top]값을 가져올 것인데,
		// A[top] < A[i]이면 
		// 계속 pop을 해서 index를 가져올 것임
		
		stack.push(0);
		for (int i = 1; i < N; i++) {
			while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
				RLN[stack.pop()] = A[i];
			}
			stack.push(i);
		}
		// 스택에 남아 있는 값들은 -1! 오큰수가 존재하지 않는 놈들임
		while (!stack.isEmpty()) {
			RLN[stack.pop()] = -1;
		}
//		for (int i = 0; i < N; i++) {
//			System.out.print(RLN[i]+ " ");
//		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			bw.write(RLN[i]+ " ");
		}
		bw.flush();
		bw.close();
	}
}