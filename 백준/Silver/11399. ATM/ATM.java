import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N; i++) {
			int k = i; // 삽입할 위치
			int insert_value = A[i];
			for(int j = i-1; j >= 0; j--) {
				if (A[j] > A[i]) {
					k = j;
				}
			}
			for(int j = i; j > k; j--) {
				A[j] = A[j-1];
			}
			A[k] = insert_value;
			
		}
		int[] S = new int[N];
		S[0] = A[0];
		
		int sum = S[0];
		for (int i = 1; i < N; i++) {
			S[i] = S[i-1] + A[i];
			sum += S[i];
		}
		System.out.println(sum);
	}
}