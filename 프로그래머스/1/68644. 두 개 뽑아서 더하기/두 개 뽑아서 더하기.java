import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int k = numbers.length;
        Set<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < k - 1; i++) {
            for (int j = i + 1; j < k; j++){
                set.add(numbers[i] + numbers[j]);
            }
                
        }
        
        int[] answer = new int[set.size()];
        int i = 0;
        for (int num : set) {
            answer[i++] = num;
        }
        
        return answer;
    }
}