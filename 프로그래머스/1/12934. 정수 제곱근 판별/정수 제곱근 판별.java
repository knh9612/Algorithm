class Solution {
    public long solution(long n) {
        double k = Math.sqrt(n);
        long answer = 0;
        if (k%1 == 0) answer = (long) Math.pow(k+1, 2);
        else answer = -1;
        
        return answer;
    }
}