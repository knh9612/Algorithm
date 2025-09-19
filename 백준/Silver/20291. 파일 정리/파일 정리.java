import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> files = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("\\.");
            files.put(split[1], files.getOrDefault(split[1], 0) + 1);
        }
        
        for (String string : files.keySet()) {
            System.out.println(string + " " + files.get(string));
        }
    }
}
