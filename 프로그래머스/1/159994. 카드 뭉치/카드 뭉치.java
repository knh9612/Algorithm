import java.util.*;

// 19시 30분 시작
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // cards 1, 2를 다 각각의 queue에 넣음
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        for (int i = 0; i < cards1.length; i++) {
            queue1.offer(cards1[i]);
        }
        
        for (int i = 0; i < cards2.length; i++) {
            queue2.offer(cards2[i]);
        }
        
        // goal에 대해 for문을 돌리면서 cards 1, 2에 해당 단어가 제일 앞에 있는지 확인
        for (int i = 0; i < goal.length; i++) {
            // 있으면 계속 진행
            if (!queue1.isEmpty() && goal[i].equals(queue1.peek())) {
                queue1.poll();
                
            } else if (!queue2.isEmpty() && goal[i].equals(queue2.peek())) {
                queue2.poll();
                
            // 없으면 No 반환    
            } else return "No";
        
        }
        
        return "Yes";
    }
}