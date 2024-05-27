import java.io.*;
import java.util.*;

// 이건 답을 봐도 모르겠음...
// 자자 문제 조건이 "어떤 수"가 "다른 두 수의 합"으로 표현되는 수의 개수를 구하는 것임
// 따라서, 0 + 4 = 4 는 카운트가 되지 않음
// 즉 포인터가 가리키고 있는 것이 자기 자신일 경우는 포함하면 안됨!!!!!
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
		Arrays.sort(A);
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			int startPointer = 0;
			int endPointer = N - 1;
			
			while (startPointer < endPointer) {
				if (A[startPointer] + A[endPointer] > A[i]) {
					endPointer--;
				} else if (A[startPointer] + A[endPointer] < A[i]) {
					startPointer++;
				} else {
					if (startPointer != i && endPointer != i) {
						answer++;
						break;
					} else if (startPointer == i) {
						startPointer++;
					} else if (endPointer == i) {
						endPointer--;
					}
				}
			}
		}
		System.out.print(answer);
		br.close();
	}
}
