import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		// 최소 비용 -> 할인을 가장 많이 받아야 함.
		// 1. 3묶음 필수
		// 2. 정렬 후 가장 작은 놈 할인
		int sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		for (int i = n-3; i >= 0; i-=3) {
			sum -= arr[i];
		}
		
		System.out.println(sum);
	}
}