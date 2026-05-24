import java.util.*;

// 19시 30분 시작
class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (isValid(s)) answer++;
            
            s = rotate(s);
            
        }
        return answer;
    }
    
    private String rotate(String s) {
        char[] charArray = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) charArray[i] = s.charAt(0);
            else charArray[i] = s.charAt(i + 1);
                
        }
            return new String(charArray);
    }
    
    private boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (!stack.isEmpty() && stack.peek() == c) stack.pop();
            else return false;
        }
        
        return stack.isEmpty();
    }
}