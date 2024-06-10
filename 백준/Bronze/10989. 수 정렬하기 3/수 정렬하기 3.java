import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {
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
		while(count != maxSize) { // 최대 자릿수만큼 반복
			int[] bucket = new int[10]; // 현재 자릿수들의 분포를 합 배열의 형태로 알려주는 배열 // ...?
			for(int i = 0; i < A.length; i++) {
				bucket[(A[i] / jarisu) % 10]++; // 일의 자리부터 시작
			}
			// 합 배열을 이용해 index 계산
			// bucket[4]이면, 현재 기준 자릿값이 0~4까지 몇 개의 데이터가 있는지 저장하는 배열..
			// 이를 통해 각 숫자가 정렬된 배열에서 어느 위치에 들어가야 하는지를 알 수 있음
			for(int i = 1; i < 10; i++) {
				bucket[i] += bucket[i-1];
			}
			// 여기가 핵심인 듯..
			//현재 자릿수를 기준으로 정렬할 때 배열의 뒤에서부터 처리하는 이유는 **안정 정렬(stable sort)**을 보장하기 위해서입니다. 
			// 안정 정렬은 동일한 키를 가진 요소들이 원래의 순서를 유지하면서 정렬되는 것을 의미합니다.
			// 예를 들어, 배열 [123, 432, 124, 423]가 있을 때, 만약 우리가 일의 자리를 기준으로 정렬한다면 3을 가진 123과 423의 순서는 변경되지 않아야 합니다. 
			// 뒤에서부터 처리하면 이를 보장할 수 있습니다.
			for(int i = A.length-1; i >= 0; i--) { // 현재 자릿수를 기준으로 정렬
				output[bucket[(A[i] / jarisu) % 10] - 1] = A[i];
				bucket[(A[i] / jarisu) % 10]--;
			}
			for(int i = 0; i < A.length; i++) {
				// 다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장
				A[i] = output[i];
			}
			jarisu *= 10; // 자릿수 증가
			count++;
		}
	}
}