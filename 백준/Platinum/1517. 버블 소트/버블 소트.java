import java.io.*;
import java.util.*;

public class Main {
	static int[] A;
	static int[] temp;
	static long count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		temp = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		count = 0;
		mergeSort(1, N);
		System.out.println(count);
	}
	static void mergeSort(int s, int e) {
		if (e-s < 1) return;
		int m = s+(e-s)/2;
		mergeSort(s, m);
		mergeSort(m+1, e);
		for(int i = s; i <= e; i++) {
			temp[i] = A[i];
		}
		int k = s;
		int index1 = s;
		int index2 = m+1;
		while(index1 <= m && index2 <= e) {
			if (temp[index1] > temp[index2]) {
				A[k] = temp[index2];
				count += index2-k;
				k++;
				index2++;
			} else {
				A[k] = temp[index1];
//				count += index1-k;
				k++;
				index1++;
			}
		}
		while(index1 <= m) {
			A[k] = temp[index1];
//			count += index1-k;
			k++;
			index1++;
		}
		while(index2 <= e) {
			A[k] = temp[index2];
//			count += index2-k;
			k++;
			index2++;
		}
	}
}