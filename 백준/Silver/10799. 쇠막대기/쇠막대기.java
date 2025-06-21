import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                Character pop = stack.pop();
                // FixME: 바로 전을 확인해야 함.
                //  stack에서 꺼내는 것이 아니라..!
                if (str.charAt(i - 1) == '(') {
                    result += stack.size();
                } else {
                    result += 1;
                }
            }
        }
        System.out.println(result);

        // 닫히지 않았을 때 ( 이면 막대기 쌓임
        // 닫혔을 때 ( 이면
        //   모두 닫혔으면 제일 아래층
        //   안 닫힌 곳이 있으면 해당 층에 쌓임


    }
}