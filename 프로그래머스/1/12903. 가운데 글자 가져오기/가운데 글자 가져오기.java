import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int k = s.length();
        if (k % 2 == 0) {
            answer = s.substring(k/2-1, k/2+1);
        } else {
            answer = s.substring(k/2, k/2+1);
        }
        
        return answer;
    }
}