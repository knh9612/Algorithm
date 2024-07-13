import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			boolean find = false;
			int target = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = A.length - 1;
			while (start <= end) {
				int mid_index = (start + end) / 2;
				int mid_value = A[mid_index];
				if (mid_value > target) {
					end = mid_index - 1;
				} else if (mid_value < target) {
					start = mid_index + 1;
				} else {
					find = true;
					break;
				}
			}
			if (find) System.out.println(1);
			else System.out.println(0);
		}
	}
}