import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 큐에 인덱스 저장
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.offer(i);
        }

        int[] answer = new int[progresses.length];
        // 큐에서 하나씩 dequeue하면서 뒤에 것 완료(진행률이 100% 이상) 여부 확인
        // 초기값 세팅
        int prevIndex = queue.poll();
        int day = (100 - progresses[prevIndex] + speeds[prevIndex] - 1) / speeds[prevIndex];
        answer[prevIndex]++;

        while (!queue.isEmpty()) {
            // dequeue시 전에 계산한 일 수로 진행률이 100% 이상인지 확인
            int curIndex = queue.poll();
            if (progresses[curIndex] + speeds[curIndex] * day >= 100) {
                // 완료가 되었으면 개수++
                answer[prevIndex]++;

            } else {
                // 안되었으면 일 수 업데이트 및 list에 개수 추가
                prevIndex = curIndex;
                answer[curIndex]++;
                day = (100 - progresses[curIndex] + speeds[curIndex] - 1) / speeds[curIndex];
            }

        }


        return Arrays.stream(answer)
                .filter(x -> x > 0)
                .toArray();
    }
}