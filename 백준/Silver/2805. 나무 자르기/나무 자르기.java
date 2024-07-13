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

		int start = 0;
		int end = A[n - 1];
		int answer = 0;

		while (start <= end) {
			int mid_value = (start + end) / 2;
			long sum = 0;
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
			} else {
				answer = mid_value;
				start = mid_value+1;
			}
		}
		System.out.println(answer);
	}
}