import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        
        int i = stack.peek();
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = i - j;
        }
        
        return answer;
    }
}