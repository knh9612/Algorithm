import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(A, 0, N-1, K-1); // K가 아니라 K-1
		System.out.println(A[K-1]);
	}
	
	public static void quickSort(int[] A, int start, int end, int K) {
		if (start < end) {
			int pivot = partition(A, start, end);
			if (pivot == K) return;
			else if (pivot < K) quickSort(A, pivot+1, end, K);
			else quickSort(A, start, pivot-1, K);
		}
	}
	
	public static int partition(int[] A, int start, int end) {
		if (start + 1 == end) { // 데이터가 2개일 경우는 바로 비교해서 정렬
		if (A[start] > A[end]) swap(A, start, end);
		return end;
	}
		int M = (start + end) / 2; // 시간 복잡도를 줄이기 위해 중앙값 사용
		int pivot = A[M];
		swap(A, start, M);
		int i = start + 1;
		int j = end;
		// i와 j를 좁혀가면서 왼쪽에는 작은 놈, 오른쪽에는 큰 놈 몰아넣기
		while(i <= j) {
			// end_pointer는 pivot보다 작은 지점 찾기
			// start_pointer는 pivot보다 큰 지점 찾기
			while(pivot < A[j] && j > start) j--;
			while(pivot > A[i] && i <= end) i++;
			// 찾은 후에 작은 지점과 큰 지점의 위치 swap -> 왼쪽은 작은 놈, 오른쪽은 큰 놈 몰아넣음
			if (i <= j) swap(A, i++, j--);
		}
		// 위에서 pivot을 A[start]에 넣어놔서 작은 놈들, 큰 놈들을 나누었기 때문에
		// 다시 pitvot값을 원래 위치로 locate
		A[start] = A[j];
		A[j] = pivot;
		return j;
	}
	
	public static void swap(int[] A, int start, int end) {
		int temp = A[start];
		A[start] = A[end];
		A[end] = temp; 
	}
}