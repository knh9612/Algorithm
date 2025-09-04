import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        String line = br.readLine();
        int i = 0;
        while (i < line.length()) {
            if (line.charAt(i) == '<') {
                while (line.charAt(i) != '>') {
                    sb.append(line.charAt(i));
                    i++;
                    if (i == line.length()) break;
                }
                sb.append(line.charAt(i));
                i++;

            } else if (line.charAt(i) == ' ') {
                sb.append(line.charAt(i));
                i++;

            } else {
                while (line.charAt(i) != ' ' && line.charAt(i) != '<') {
                    stack.push(line.charAt(i));
                    i++;
                    if (i == line.length()) break;
                }
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }
        System.out.println(sb);

    }
}
