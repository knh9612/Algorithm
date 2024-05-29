import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> st = new Stack<>();
		int num = 1; // 얘랑 A[]에 있는 값이랑 비교하면서 스택에 값을 넣었다 뺏다 할 예정
		StringBuffer sf = new StringBuffer();
		for (int i = 0; i < N; i++) {
			int k = A[i];
			// A[]의 값을 하나씩 빼서 num과 비교 후
			// 1. k >= num이면 num이 k가 될 때까지 증가시키면서 num을 스택에 넣을 예정
			
			// 2. k < num이면 스택에서 pop... 근데 여기서 주의할 점이 있음
			// pop한 값을 n이라고 했을 때, n과 A[i]의 값 즉 n과 k의 값을 비교해야 함
			// 2-1. 출력해야 하는 값이 k인데, n > k이면 출력을 할 수가 없음!!!!!!! 
			// 따라서 이 경우 "NO"를 출력해야 함
			// 2-2. n < k인 경우는 "-" 출력 ????????
			// -> 이렇게만 하면 완료ㅇㅇㅇ
			// 다른 문제 풀어보면서 유형 익혀야 할 듯
			if (k >= num) {
				while (k >= num) {
					st.push(num++);
					sf.append("+\n");
				}
				st.pop();
				sf.append("-\n");
			} else {
				int n = st.pop();
				if (n > k) {
					System.out.println("NO");
					return;
				} else {
					sf.append("-\n");
				}	
			}
		}
		System.out.println(sf.toString());
	}
}