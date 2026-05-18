import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int size = numbers.length;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
            
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        List<Integer> list = new ArrayList<>(set);
        int[] answer = new int[list.size()];
        Collections.sort(list);
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}