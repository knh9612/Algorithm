import java.util.*;

class Solution {
    public List<Integer> solution(int N, int[] stages) {
        double[] failRates = new double[N];

        // 이중 for문을 돌면서 실패율 계산
        for (int i = 1; i <= N; i++) {
            int fail = 0;
            int reach = 0;

            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) fail++;
                if (stages[j] >= i) reach++;
            }

            if (reach != 0) {
                failRates[i - 1] = (double) fail / reach;

            }

        }

        // 실패율이 높은 스테이지 번호부터 반환(내림차순 정렬)
        // 스테이지 번호 저장
        List<Integer> answer = new ArrayList<>();
        double max = -1;

        for (int i = 0; i < N; i++) {
            // max 찾고
            for (int j = 0; j < N; j++) {
                if (failRates[j] > max) max = failRates[j];
            }

            // answer 배열에 추가
            for (int j = 0; j < N; j++) {
                if (max == failRates[j]) {
                    answer.add(j + 1);
                    failRates[j] = -2;
                }

            }
            // max 초기화 등
            max = -1;

        }


        return answer;
    }
}