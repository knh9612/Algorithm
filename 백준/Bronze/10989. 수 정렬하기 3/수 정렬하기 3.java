import java.io.*;
import java.util.*;

// 기수 정렬 다시 풀기
// 일의 자리부터 같은 자릿수의 값만 비교하여 정렬
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		radixSort(A, 5);
		for(int i = 0; i < N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void radixSort(int[] A, int maxSize) {
		int[] output = new int[A.length]; // 임시 정렬을 위한 배열
		int jarisu = 1;
		int count = 0;
		while(count != maxSize) {
			int[] bucket = new int[10]; // 자릿수들의 분포를 알려주는 배열
			for(int i = 0; i < A.length; i++) {
				bucket[(A[i]/jarisu)%10]++; // 일의 자리부터 정렬
			}
			// bucket을 합 배열로 전환
			for(int i = 1; i < 10; i++) {
				bucket[i] += bucket[i-1];
			}
			for(int i = A.length-1; i >= 0; i--) { // 현재 자릿수를 기준으로 정렬
				output[--bucket[(A[i]/jarisu)%10]] = A[i];
			}
			for(int i = 0; i < A.length; i++) {
				A[i] = output[i];
			}
			jarisu *= 10;
			count++;
		}
	}
}