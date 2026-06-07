import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[prices.length];
        // 각 가격들을 stack에 넣으면서 (가격을 넣으면 시간 계산을 할 수 없으므로 index를 넣음)
        // 떨어졌을 때 시간을 개산하면서 pop();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - 1 - index;
        }
        
        return answer;
    }
}