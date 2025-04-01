import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = 0;
		Arrays.sort(array);
		int[] freq = new int[8001];
		
		for (int i = 0; i < n; i++) {
			sum += array[i];
			freq[4000 + array[i]]++;
		}
		
		// 1.
		int mean = (int) Math.round((double) sum / n);
		// 2.
		int middle = array[(n-1)/2];
		// 3.
		// 최빈값
		int maxFreq = 0;
		// 최빈값을 가진 int
		int k = 0;
		// 유일한 최빈값인지 판단하기 위한 boolean
		boolean isUnique = true;
		
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > maxFreq) {
				maxFreq = freq[i];
				k = i - 4000;
				isUnique = true;
			} else if (freq[i] == maxFreq && isUnique) {
				k = i - 4000;
				isUnique = false;
			}
		}
		// 4.
		int range = array[n-1] - array[0];
		
        // StringBuilder를 사용해 모든 출력을 하나의 문자열로 구성
        StringBuilder sb = new StringBuilder();
        sb.append(mean).append("\n")
          .append(middle).append("\n")
          .append(k).append("\n")
          .append(range);
        
        // 한 번의 write 호출로 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
		
	}
}