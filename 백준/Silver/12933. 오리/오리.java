import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

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

            StringBuilder sb = new StringBuilder();
            int pointer = 0;
            for (int i = 0; i < line.length(); i++) {
                if (charSet[pointer] == line.charAt(i)) {
                    pointer++;

                    if (pointer == 5) {
                        pointer = 0;
                    }

                } else {
                    sb.append(line.charAt(i));
                }

            }
            count++;
            if (sb.length() == 0) {
                System.out.println(count);
                return;
            }

            line = String.valueOf(sb);
        }
    }
}
