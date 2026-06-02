import java.util.*;

class Solution {

    public int[] solution(int[] answers) {
        // 각 수포자의 반복 패턴
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 정답 수를 저장하는 배열 선언
        int[] scores = new int[3];

        // 문제 풀이
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) {
                scores[0]++;
            }

            if (answers[i] == pattern2[i % pattern2.length]) {
                scores[1]++;
            }

            if (answers[i] == pattern3[i % pattern3.length]) {
                scores[2]++;
            }
        }

        // 최고 득점 찾기
        int maxScore = -1;
        for (int score : scores) {
            if (score > maxScore) maxScore = score;
        }

        // 최고 득점자 찾기
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) answer.add(i + 1);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
}