import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String sl = st.nextToken();
        String sr = st.nextToken();
        String[] line = br.readLine().split("");
        Node left = findKeyCoords(sl);
        Node right = findKeyCoords(sr);
        int time = 0;

        for (int i = 0; i < line.length; i++) {
            // 좌표 반환
            Node cur = findKeyCoords(line[i]);

            // 왼손인지 오른손인지 판단
            // 4 < y || y == 4 && x == 2 이면 오른손, 아니면 왼손
            if (cur.y > 4 || cur.y == 4 && cur.x == 2) {
                time += Math.abs(right.x - cur.x) + Math.abs(right.y - cur.y) + 1;
                right.x = cur.x;
                right.y = cur.y;

            } else {
                time += Math.abs(left.x - cur.x) + Math.abs(left.y - cur.y) + 1;
                left.x = cur.x;
                left.y = cur.y;
            }

        }
        System.out.println(time);
    }

    private static Node findKeyCoords(String line) {
        String[][] map = {
                {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"},
                {"a", "s", "d", "f", "g", "h", "j", "k", "l", "null"},
                {"z", "x", "c", "v", "b", "n", "m", "null", "null", "null"}
        };

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 10; k++) {
                if (map[j][k] == null) {
                    continue;
                }
                if (map[j][k].equals(line)) {
                    return new Node(j, k);
                }
            }
        }
        return null;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
