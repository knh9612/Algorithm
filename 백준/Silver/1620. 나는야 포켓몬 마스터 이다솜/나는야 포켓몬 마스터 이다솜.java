import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());
        Map<Integer, String> intStr = new HashMap<>();
        Map<String, Integer> strInt = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            intStr.put(i, str);
            strInt.put(str, i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (Character.isDigit(str.charAt(0))) {
                bw.write(intStr.get(parseInt(str)) + "\n");
            } else {
                bw.write(strInt.get(str) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}