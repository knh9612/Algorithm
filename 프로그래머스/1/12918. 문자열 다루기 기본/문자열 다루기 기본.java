import java.util.*;

class Solution {
    public boolean solution(String s) {
        char[] charArray = s.toCharArray();
        boolean answer = true;
        
        if (charArray.length != 4 && charArray.length != 6) {
            answer = false;
            return answer;
            
        }
            
        
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] < 48 || 57 < charArray[i]) {
                answer = false;
                return answer;
            }
         }
        return answer;
    }
}