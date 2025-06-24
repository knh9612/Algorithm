import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> tm = new TreeMap<>();
        String tree;
        int total = 0;

        while ((tree = br.readLine()) != null && !tree.isEmpty()) {
            tm.put(tree, tm.getOrDefault(tree, 0) + 1);
            total++;
        }

        for (String str : tm.keySet()) {
            double k = (double) tm.get(str) / total * 100;
            System.out.printf("%s %.4f%n", str, k);
        }


    }
}