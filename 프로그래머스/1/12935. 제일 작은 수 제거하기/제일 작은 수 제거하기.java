import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[] {-1};
        
        int[] answer = new int[arr.length-1];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
        }
        
        int index = 0;
        for (int k : arr) {
            if (k != min) answer[index++] = k;
        }
        
        return answer;
    }
}