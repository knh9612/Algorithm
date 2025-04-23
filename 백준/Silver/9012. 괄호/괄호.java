import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    /**
     * 괄호가 한 쌍으로 제대로 돼 있는지 없는지 판단하는 문제.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            sb.append(isVpc(br.readLine().split("")) ? "YES" + "\n" : "NO" + "\n");
        }
        br.close();
        System.out.println(sb.toString());
    }

    private static boolean isVpc(String[] psList) {
        Deque<String> dq = new ArrayDeque<>();
        int right = 0;
        for (String s : psList) {
            dq.push(s);
        }
        for (String s : dq) {
            if (s.equals(")")) {
                right++;
            } else {
                if (--right < 0) {
                    return false;
                }
            }
        }
        if (right == 0) return true;
        else return false;
    }
}