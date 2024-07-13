import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] A = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);

//		int start = A[0];
		int start = 0; // 문제에서 나무의 높이가 0부터라고 주어졌기 때문에 0으로 변경
		int end = A[n - 1];
		int answer = 0;

		while (start <= end) {
			int mid_value = (start + end) / 2;
//			int sum = 0;
			long sum = 0; // 합을 long으로 변경하여 큰 값 처리!
			for (int i = 0; i < n; i++) {
				if (A[i] >= mid_value) {
					sum += A[i] - mid_value;
				}
			}
			if (sum < m) {
				end = mid_value - 1;
//			} else if (sum > m) {
//				start = mid_value + 1;
//			} else {
//				answer = mid_value;
//				break;
			} else { // 아마 "적어도"라는 표현 때문에 이렇게 처리해야 할 듯!
				// 다른 문제 풀어보면서 감 ㄱㄱ
				answer = mid_value;
				start = mid_value+1;
			}
		}
		System.out.println(answer);
	}
}