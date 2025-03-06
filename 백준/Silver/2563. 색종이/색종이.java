import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[100][100];
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int j = x; j < x + 10; j ++) {
				for (int k = y; k < y + 10; k++) {
					
					if (!map[j][k]) {
						map[j][k] = true;
						result++;
					}
				}
			}
		}
		
		System.out.println(result);
	}
}