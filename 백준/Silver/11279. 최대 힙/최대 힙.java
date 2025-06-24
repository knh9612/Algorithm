import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());


        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0) {
                if (maxHeap.isEmpty()) {
                    bw.write(0 + "\n");
                } else {
                    bw.write(maxHeap.poll()+"\n");
                }

            } else {
                maxHeap.add(k);
            }
        }

        bw.flush();
        bw.close();
    }
}