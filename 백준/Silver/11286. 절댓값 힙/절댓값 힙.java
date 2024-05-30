import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
			// 여기서 -1, 0, 1의 값이 중요한 것이 아니라 부호가 중요!
			// 반환 값이 음수이면, 첫 번째 인자가 두 번째 인자보다 작음
			// 반환 값이 0이면, 두 인자가 같음.
			// 반환 값이 양수이면, 첫 번째 인자가 두 번째 인자보다 큼
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if (first_abs == second_abs) {
				return o1 - o2 > 0 ? 1 : -1; // 절댓값이 같을 때, o1 > o2이면 양수
			} else {
				return first_abs - second_abs; // 절대 값이 같지 않을 때는 크기 비교
				// 첫 번째 값이 작으면 음수를 반환하므로 ㄱㅊ!
				// 첫 번째 값이 크면 양수를 반환하므로 정렬 해줌
			}
		});
		
		for (int i = 0; i < N; i++) {
			int k = Integer.parseInt(br.readLine());
			if (k == 0) {
				if (q.isEmpty()) System.out.println("0");
				else System.out.println(q.poll()); 
			} else q.add(k);
		}
	}
}