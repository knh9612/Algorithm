import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 != abs2) {
                return Integer.compare(abs1, abs2); // 절댓값 비교
            }
            return Integer.compare(o1, o2); // 실제 값 비교
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0) {
                if (pq.isEmpty()) bw.write(0 + "\n");
                else bw.write(pq.poll() + "\n");
            } else {
                pq.add(k);
            }
        }
        
        bw.flush();
        bw.close();
    }
}