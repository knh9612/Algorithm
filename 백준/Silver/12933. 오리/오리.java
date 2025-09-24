import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Queue<Character> queue2 = new ArrayDeque<>();
        char[] charSet = {'q', 'u', 'a', 'c', 'k'};

        int count = 0;
        while (true) {
            if (line.length() % 5 != 0) {
                System.out.println(-1);
                return;
            }
            
            if (line.charAt(0) != 'q') {
                System.out.println(-1);
                return;
            }

            Queue<Character> queue1 = new ArrayDeque<>();
            int pointer = 0;
            for (int i = 0; i < line.length(); i++) {
                if (charSet[pointer] == line.charAt(i)) {
                    queue1.offer(line.charAt(i));
                    pointer++;

                    if (pointer == 5) {
                        pointer = 0;
                    }

                } else {
                    queue2.offer(line.charAt(i));
                }

            }
            count++;
            if (queue2.isEmpty()) {
                System.out.println(count);
                return;
            }

            StringBuilder sb = new StringBuilder();
            while (!queue2.isEmpty()) {
                sb.append(queue2.poll());
            }
            line = String.valueOf(sb);
        }
    }
}
