import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int k = Integer.parseInt(br.readLine());
			
			if (k == 0) {
				if(!pq.isEmpty()) System.out.println(pq.poll());
				else System.out.println("0");
			} else pq.add(k);
		}
	}
}