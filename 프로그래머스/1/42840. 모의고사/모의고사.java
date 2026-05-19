import java.util.*;

// 20시 시작
class Solution {
    public List<Integer> solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];
        
        // 1번 수포자가 찍는 방식
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length]) {
                scores[0]++;
            }
        }
        
        // 2번 수포자가 찍는 방식
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == second[i % second.length]) {
                scores[1]++;
            }
        }

        
        // 3번 수포자가 찍는 방식
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == third[i % third.length]) {
                scores[2]++;
            }
        }

        // 가장 높은 점수를 받은 사람 찾기
        int max = -1;
        for (int i = 0; i < scores.length; i++) {
            if (max < scores[i]) max = scores[i];
        }
        
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < scores.length; i++) {
            if (max == scores[i]) list.add(i + 1);
        }
        
        Collections.sort(list);
        
        return list;
    }
    
}