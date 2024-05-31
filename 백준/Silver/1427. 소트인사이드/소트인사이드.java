import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		int[] A = new int[str.length];
		
		for (int i = 0; i < str.length; i++) {
			A[i] = Integer.parseInt(str[i]);
		}
		
		// 일단 index를 사용해서 함 ㄱㄱ
		// 가장 첫번째 index부터 채워지기 때문
		for (int i = 0; i < A.length-1; i++) {
			int max = i;
			for (int j = i+1; j < A.length; j++) {
				if (A[max] < A[j]) {
					max = j; // 선택 정렬이니까 최댓 값 먼저 찾기
				}
			}
			if (A[i] < A[max]) {
				int temp = A[i];
				A[i] = A[max];
				A[max] = temp;
			}
		}
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}
	}
}