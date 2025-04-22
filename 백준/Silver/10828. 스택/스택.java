import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if (s.startsWith("push")) {
                stack.push(Integer.parseInt(s.substring(5)));
            }
            switch (s) {
                case "pop":
                    sb.append(stack.isEmpty() ? -1 + "\n" : stack.pop() + "\n");
                    break;
                case "size":
                    sb.append(stack.size() + "\n");
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 + "\n" : 0 + "\n");
                    break;
                case "top":
                    sb.append(stack.isEmpty() ? -1 + "\n" : stack.peek() +"\n");
                    break;
            }
        }
        br.close();
        System.out.println(sb.toString());
    }
}