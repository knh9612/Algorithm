import java.util.*;

class Solution {
    public int solution(String s) {
        // stack 생성
        Deque<Character> stack = new ArrayDeque<>();
        
        // top과 같은지 비교하면서 push
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
                
            } else {
                stack.push(c);            
            }
                
        }
        
        // stack이 비어있으면 1, 아니면 0 return
        return stack.isEmpty() ? 1 : 0;
    }
}