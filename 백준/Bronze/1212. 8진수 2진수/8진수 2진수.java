import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String octal = br.readLine();
        if (octal.equals("0")) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[octal.length()];
        for (int i = 0; i < octal.length(); i++) {
            arr[i] = octal.charAt(i) - '0';
        }

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                sb.append(arr[i] % 2);
                arr[i] /= 2;
            }
        }

        sb.reverse();

        while ((sb.charAt(0) - '0') == 0) {
            sb.deleteCharAt(0);
        }

        System.out.println(sb);

    }
}
