import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[10_000];
            Map<Integer, String> preNode = new HashMap<>();
            int[] preVal = new int[10_000];
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 시작 노드 예약
            queue.add(A);
            visited[A] = true;
            preVal[A] = -1;
            preNode.put(A, "START");

            while (!queue.isEmpty()) {
                // 현재 노드 방문
                int cur = queue.remove();
                Deque<Integer> stack = new ArrayDeque<>();

                if (cur == B) {
                    for (int j = B; j != -1; j = preVal[j]) {
                        stack.push(j);
                    }
                    stack.pop();
                    while (!stack.isEmpty()) {
                        bw.write(preNode.get(stack.pop()));
                    }
                    bw.newLine();
                    break;
                }

                // 다음 노드 예약
                for (int next : new int[]{d(cur), s(cur), l(cur), r(cur)}) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                        preVal[next] = cur;

                        if (next == d(cur)) {
                            preNode.put(next, "D");

                        } else if (next == s(cur)) {
                            preNode.put(next, "S");

                        } else if (next == l(cur)) {
                            preNode.put(next, "L");

                        } else if (next == r(cur)) {
                            preNode.put(next, "R");

                        }

                    }
                }
            }

        }
        bw.flush();


    }

    static int d(int n) {
        return 2 * n % 10_000;
    }

    static int s(int n) {
        if (n != 0) return n - 1;
        else return 9999;
    }

    static int l(int n) {
        int d1 = n / 1000;        // 천의 자리
        int rest = n % 1000;      // 나머지 세 자리

        return (rest * 10) + d1;
    }

    static int r(int n) {
        int d4 = n % 10;          // 일의 자리
        int rest = n / 10;        // 앞의 세 자리

        return d4 * 1000 + rest;
    }

}
