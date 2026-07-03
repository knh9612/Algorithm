import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 1.enroll 배열을 Map으로 변환 (판매원, index)
        Map<String, Integer> employeeMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            employeeMap.put(enroll[i], i);
        }

        // 2. Map으로 판매원 - 추천인 관계 표현 (판매원, 추천인)
        Map<String, String> tree = new HashMap<>();
        for (int i = 0; i < referral.length; i++) {
            tree.put(enroll[i], referral[i]);
        }

        int[] answer = new int[enroll.length];
        // 3. seller와 amount를 돌면서 수익 배분
        for (int i = 0; i < seller.length; i++) {
            // 이익금 계산
            int profits = amount[i] * 100; // 1000
            // 판매원 저장
            String child = seller[i];

            // 이익금 배분
            while (!child.equals("-") && profits > 0) {
                int toParent = profits / 10;
                int own = profits - toParent;

                answer[employeeMap.get(child)] += own;

                profits = toParent;
                child = tree.get(child);
            }
        }

        return answer;
    }
}