import java.util.*;
// 12:00 시작
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        // 큐에 인덱스 저장
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.offer(i);
        }
        
        List<Integer> list = new ArrayList<>();
        // 큐에서 하나씩 dequeue하면서 뒤에 것 완료(진행률이 100% 이상) 여부 확인
        // 초기값 세팅
        int first = queue.poll();
        int day = (100 - progresses[first] + speeds[first] - 1) / speeds[first];
        int count = 1;
        
        while (!queue.isEmpty()) {
            // dequeue시 전에 계산한 일 수로 진행률이 100% 이상인지 확인
            int curIndex = queue.poll();
            if (progresses[curIndex] + speeds[curIndex] * day >= 100) {
                // 완료가 되었으면 개수++
                count++;
                
            } else {
                // 안되었으면 일 수 업데이트 및 list에 개수 추가
                list.add(count);
                count = 1; // 초기화
                day = (100 - progresses[curIndex] + speeds[curIndex] - 1) / speeds[curIndex];
            }
            
        }
        // 마지막 count 추가
        list.add(count);
        
        
        return list;
    }
}