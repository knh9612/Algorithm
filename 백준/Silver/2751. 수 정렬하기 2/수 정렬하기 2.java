import java.io.*;

// System.out.print로 하니까 시간초과...
public class Main {
		static int[] A;
		static int[] temp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		temp = new int[N+1];
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		mergeSort(1, N);
		for(int i = 1; i <= N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
	static void mergeSort(int s, int e) {
		if (e-s < 1) return;
		int m = s + (e-s)/2;
		mergeSort(s, m);
		mergeSort(m+1, e);
		for(int i = s; i <= e; i++) {
			temp[i] = A[i];
		}
		int k = s;
		int index1 = s;
		int index2 = m+1;
		while(index1 <= m && index2 <= e) {
			if (temp[index1] < temp[index2]) {
				A[k] = temp[index1];
				k++;
				index1++;
			} else {
				A[k] = temp[index2];
				k++;
				index2++;
			}
		}
		while(index1 <= m) {
			A[k] = temp[index1];
			k++;
			index1++;
		}
		while(index2 <= e) {
			A[k] = temp[index2];
			k++;
			index2++;
		}
	}
}