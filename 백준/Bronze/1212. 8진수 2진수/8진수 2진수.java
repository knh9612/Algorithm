import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String octal = br.readLine();

        // 0 예외 처리
        if (octal.equals("0")) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();

        // 첫 번째 숫자는 앞자리 0 제거 위해 별도 처리
        int first = octal.charAt(0) - '0';
        sb.append(Integer.toBinaryString(first));

        // 나머지 숫자들은 반드시 3자리 이진수로 변환
        for (int i = 1; i < octal.length(); i++) {
            int num = octal.charAt(i) - '0';
            String bin = Integer.toBinaryString(num);
            // 3자리가 안 되면 앞에 0을 채움
            while (bin.length() < 3) {
                bin = "0" + bin;
            }
            sb.append(bin);
        }

        System.out.println(sb);
    }
}
