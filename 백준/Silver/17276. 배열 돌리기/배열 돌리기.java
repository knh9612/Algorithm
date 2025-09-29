import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int[][] graph = new int[n + 1][n + 1];
            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    graph[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if (d > 0) {
                graphRotate(graph, d);

            } else if (d == 0) {

            } else {
                graphReverseRotate(graph, d);

            }
            printGraph(sb, graph);
        }
        System.out.println(sb);
    }

    private static void printGraph(StringBuilder sb, int[][] graph) {
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

    }

    private static void graphRotate(int[][] graph, int d) {
        // 아래 1~4 과정을 (d / 45)만큼 반복
        for (int t = 0; t < d / 45; t++) {
            int[] temp1 = new int[graph.length];
            int[] temp2 = new int[graph.length];

            // 1. 주 대각선을 가운데 열로 회전
            for (int i = 1; i < graph.length; i++) {
                temp1[i] = graph[i][graph.length / 2];
                graph[i][graph.length / 2] = graph[i][i];
            }
            // 2. 가운데 열을 부 대각선으로 회전
            for (int i = 1; i < graph.length; i++) {
                temp2[i] = graph[i][graph.length - i];
                graph[i][graph.length - i] = temp1[i];
            }
            // 3. 부 대각선을 가운데 행으로 회전
            for (int i = 1; i < graph.length; i++) {
                temp1[i] = graph[graph.length / 2][graph.length - i];
                graph[graph.length / 2][graph.length - i] = temp2[i];
            }
            // 4. 가운데 행을 주 대각선으로 회전
            for (int i = 1; i < graph.length; i++) {
                graph[graph.length - i][graph.length - i] = temp1[i];
            }

        }
    }

    private static void graphReverseRotate(int[][] graph, int d) {
        // 아래 1~4 과정을 (d / 45)만큼 반복
        for (int t = 0; t < Math.abs(d / 45); t++) {
            int[] temp1 = new int[graph.length + 1];
            int[] temp2 = new int[graph.length + 1];

            // 1. 주 대각선을 가운데 행으로 회전
            for (int i = 1; i < graph.length; i++) {
                temp1[i] = graph[graph.length / 2][i];
                graph[graph.length / 2][i] = graph[i][i];
            }
            // 2. 가운데 행을 부 대각선으로 회전
            for (int i = 1; i < graph.length; i++) {
                temp2[i] = graph[graph.length - i][i];
                graph[graph.length - i][i] = temp1[i];
            }
            // 3. 부 대각선을 가운데 열로 회전
            for (int i = 1; i < graph.length; i++) {
                temp1[i] = graph[graph.length - i][graph.length / 2];
                graph[graph.length - i][graph.length / 2] = temp2[i];
            }
            // 4. 가운데 열을 주 대각선으로 회전
            for (int i = 1; i < graph.length; i++) {
                graph[graph.length - i][graph.length - i] = temp1[i];
            }
        }
    }
}
