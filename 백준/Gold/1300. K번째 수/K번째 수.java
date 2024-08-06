import java.io.*;
import java.util.*;

// 아이디어 문제인 듯...
// 이진탐색이 진짜 생각 안 났음....
// 1. 이진탐색의 범위 설정
// 2. 아이디어....
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		// n의 범위가 10^5이기 때문에 이중 for문을 돌리면 시간 초과 날 듯...
		
		// 배열에서 K번 째 수를 구하는 건데...
		// 문제를 해석하면, 2차원 배열을 1차원 배열에 담았을 때,
		// k번째 수의 값은 k를 넘을 수 없다..!
		// 따라서 이진탐색의 범위는 1부터 k까지 설정
		int start = 1;
		int end = k;
		int answer = 0;
		while (start <= end) {
			int mid = (start+end) / 2;
			// 아이디어!!!!!!!!!!
			// 각 행에서 중앙값(mid)보다 작거나 같은 수의 개수는, 중앙값(mid)을 각 행의 값(n)으로 나눈 값이다.
			// 따라서 그 값을 모두 더하면 중앙값(mid)보다 작거나 같은 수의 개수가 나온다. 그 개수를 count라 하자.
			// ***즉, mid 값은 최대 count번째 수이다...!!!!
			
			// 그리고 그 count와 k값 비교....
			int count = 0;
			for (int i = 1; i <= n; i++) {
				count += Math.min(mid/i, n); // n=3, mid=4, i=1일 때 mid/i는 4인데 
											 //	한 행의 최대 크기는 n인 3이므로 Math.min()으로 개수 count.
			}
			// 배열에 담겨 있는 값들이 연속적이지 않을 수 있음.....
			
			// count < k : mid보다 작거나 같은 수의 개수가 k보다 작으면, 탐색 범위를 더 큰 쪽으로 변경
			if (count < k) start = mid + 1;
			
			// k < count : mid보다 작거나 같은 수의 개수가 k보다 크면, 탐색 범위를 작은 쪽으로 변경
			// k == count : count == k 일 때도, 범위를 작은 쪽으로 변경해야 한다..! 
			// ***mid값은 최대 count번째 수이기 때문에, k번째 수는 k <= count인 곳에서 나온다..! 따라서 정답 update
			else {
				end = mid - 1;
				answer = mid;
			}
		}
		System.out.println(answer);
	}
}