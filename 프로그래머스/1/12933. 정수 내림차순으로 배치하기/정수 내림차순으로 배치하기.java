import java.util.*;

class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        Integer[] A = new Integer[str.length()];
        
        for (int i = 0; i < A.length; i++) {
            A[i] = (int)(n%10);
            n = n/10;
      }
        Arrays.sort(A, Collections.reverseOrder());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            answer.append(A[i]);
        }
        return Long.parseLong(answer.toString());
    }
}