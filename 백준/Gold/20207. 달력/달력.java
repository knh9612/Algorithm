import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Node> scheduleList = new ArrayList<>();

        // 가로 길이 확인 용
        int min = 0;
        int max = 0;

        // 일단 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            if (i == 0) {
                min = S;
                max = E;
            } else {
                if (S < min) min = S;
                if (E > max) max = E;
            }

            scheduleList.add(new Node(S, E));
        }

        // start 기준 오름차순, end 기준 내림차순 정렬
        scheduleList.sort(Comparator
                .comparingInt((Node n) -> n.start)
                .thenComparing((n1, n2) -> Integer.compare(n2.end, n1.end)));


        // 일정 로직 시작
        List<int[]> calender = new ArrayList<>();
        calender.add(new int[max + 1]);

        for (Node node : scheduleList) {
            boolean flag = false;
            for (int i = 0; i < calender.size(); i++) {
                if (calender.get(i)[node.start] == 0) {
                    for (int j = node.start; j <= node.end; j++) {
                        calender.get(i)[j] = 1;
                    }
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                int[] newLine = new int[max + 1];
                for (int i = node.start; i <= node.end; i++) {
                    newLine[i] = 1;
                }
                calender.add(newLine);
            }
        }


        // 코딩지 로직 시작
        int width = 0;
        int maxHeight = 0;
        int size = 0;
        for (int i = min; i <= max; i++) {
            int height = 0;
            for (int[] line : calender) {
                if (line[i] == 1) height++;
            }

            if (height >= maxHeight) {
                maxHeight = height;
            }

            if (height > 0) {
                width++;

            } else {
                size += width * maxHeight;
                width = 0;
                maxHeight = 0;
            }

            if (i == max && height > 0) {
                size += width * maxHeight;
            }
        }

        System.out.println(size);

    }

    static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
