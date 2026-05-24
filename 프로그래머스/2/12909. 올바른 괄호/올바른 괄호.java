import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] charArray = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '(') {
                stack.push(')');
                
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                stack.pop();
            }
        }

        return stack.isEmpty() ? true : false;
    }
}