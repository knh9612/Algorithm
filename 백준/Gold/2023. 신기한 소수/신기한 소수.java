import java.io.*;
import java.util.*;

// N자리의 숫자 중 "신기한 소수"를 모두 찾기 // 개수 아님, 모두 출력

// 왼쪽부터 소수인 애들을 어떤 자료구조에 담을지 고민했는데,
// 담을 필요가 없었음.
// 재귀함수로 계속 파라미터로 보낸 후
// 마지막까지 남아 있는 놈(신기한 소수인 놈)을 출력하면 됐음
public class Main {
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
	}
	
	static void dfs(int num, int jarisu) {
		if (jarisu == N) {
			if (isPrime(num)) System.out.println(num);
			return;
		}
		for (int i = 1; i <= 9; i+=2) {
			if (isPrime(num*10 + i)) {
				dfs(num*10+i, jarisu+1);
			}
		}
	}
	
	// 소수 판별.. 2부터 제곱근까지 나눴을 때
	// 나누어 떨어지지 않으면 그 수는 소수
	static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num%i == 0) return false;
		}
		return true;
	}
}