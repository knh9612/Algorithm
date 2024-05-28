import java.io.*;
import java.util.*;

public class Main {
	
	static int[] myArr;
	static int[] checkArr;
	static int check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		checkArr = new int[4]; // 문제에서 설정한 문자 각각의 최소 값
		myArr = new int[4]; // 슬라이딩 윈도우의 각각의 문자 개수
		check = 0; // myArr의 index 값이 만족하면(checkArr의 index 값이랑 같으면) ++ -> 다 만족하면 4
		int answer = 0;
		char[] A = new char[S];
		A = br.readLine().toCharArray(); // 한 줄 받아서 char배열로 변환
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if (checkArr[i] == 0) {
				check++;
			}
		}
		// 일단 여기까지 입력 값 다 받음
		// 이제 myArr에 넣으면서 개수 count
		for (int i = 0; i < P; i++) {
			add(A[i]);
		}
		if (check == 4) {
			answer++;
		}
		// 슬라이딩 윈도우 구현. 첫번째 index 제거하고, 마지막 다음 index 추가
		for (int i = P; i < S; i++) {
			remove(A[i-P]);
			add(A[i]);
			if (check == 4) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	// char문자 하나를 파라미터로 받아서 어떤 char인지 판별 후 myArr배열 count
	// myArr의 index값이 checkArr의 index 값을 만족하면 check값 ++
	// 부등호가 아닌 같을 때 ++인 이유는 이상이기만 하면 문제의 조건을 만족하기 때문
	private static void add(char c) {
		switch (c) {
		case 'A':
			myArr[0]++; // A일 때 A에 해당하는 myArr의 index 값 ++
			if (myArr[0] == checkArr[0]) {
				check++;
			}
			break;
		case 'C':
			myArr[1]++;
			if (myArr[1] == checkArr[1]) {
				check++;
			}
			break;
		case 'G':
			myArr[2]++;
			if (myArr[2] == checkArr[2]) {
				check++;
			}
			break;
		case 'T':
			myArr[3]++;
			if (myArr[3] == checkArr[3]) {
				check++;
			}
			break;
		}
	}
	// 제거한 후에 해당 char가 checkArr를 만족하지 않으면 check를 --해야 함
	// -> myArr[i] == checkArr[i]가 같으면 check--
	// -> remove할 건데 같으면, 제거 이후에는 checkArr 값을 만족하지 않을 것이기 때문 
	// 이후 myArr[i]--
	private static void remove(char c) {
		switch (c) {
		case 'A':
			if (myArr[0] == checkArr[0]) {
				check--;
			}
			myArr[0]--;
			break;
		case 'C':
			if (myArr[1] == checkArr[1]) {
				check--;
			}
			myArr[1]--;
			break;
		case 'G':
			if (myArr[2] == checkArr[2]) {
				check--;
			}
			myArr[2]--;
			break;
		case 'T':
			if (myArr[3] == checkArr[3]) {
				check--;
			}
			myArr[3]--;
			break;
		}
	}
}