import java.io.*;
import java.util.*;

// BufferedWriter를 StringBuffer로 변경
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		boolean result = true;
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> st = new Stack<>();
		int num = 1; // 살짝 포인터라고 생각하면 될 듯 -> 이것에 대한 정의? 이해가 완벽하면 앞으로도 좋을 듯...!
		// 1부터 자연수를 증가시키면서 입력으로 주어진 숫자와 비교하여 증가시킨 자연수를 스택에 추가하는 방식으로 전개
		
		StringBuffer sf = new StringBuffer();
		for (int i = 0; i < A.length; i++) {
			int k = A[i]; // 현재 수열의 수
			if (k >= num) { // k가 num 보다 같거나 크면 (같을 때도 push를 해야 하므로)
				while (k >= num) { // num이 k와 같아질 때까지 push, num++
					st.push(num++);
					// push 하면 +를 출력해야 하므로 일단 bw에 담아놓기
					sf.append("+\n");
				}
				// num > k가 되면 가장 위에 있는 놈 출력
				st.pop();
				// pop 했으니 -를 bw에 담기
				sf.append("-\n");
			} else { // k < num 일 때, num이 k와 같아질 때까지 --해줘야 함
				int n = st.pop();
				// 스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력할 수 없음
				if (n > k) {
					System.out.println("NO");
					result = false;
					break;
				} else {
					sf.append("-\n");
				}
			}
		}
		if (result) System.out.println(sf.toString());
	}
}