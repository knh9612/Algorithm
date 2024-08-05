class Solution {
    public int[] solution(long n) {
        // n의 자릿수를 알아야 함
        int[] answer = new int[String.valueOf(n).length()];
      
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int) (n%10);
            n = n/10;
        }
            
        
        
        return answer;
    }
}