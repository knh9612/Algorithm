import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 0, 양수 저장
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 음수 저장
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());

            if (k > 0) {
                minHeap.add(k);
            } else if (k < 0) {
                maxHeap.add(k);
            } else {
                if (minHeap.isEmpty() && maxHeap.isEmpty()) {
                    bw.write(0 + "\n");
                } else if (minHeap.isEmpty()) {
                    bw.write(maxHeap.poll() + "\n");
                } else if (maxHeap.isEmpty()) {
                    bw.write(minHeap.poll() + "\n");
                } else {
                    int a = minHeap.peek();
                    int b = -maxHeap.peek();

                    if (a >= b) {
                        bw.write(maxHeap.poll() + "\n");
                    } else {
                        bw.write(minHeap.poll() + "\n");
                    }
                }

            }
        }

        bw.flush();
        bw.close();
    }
}