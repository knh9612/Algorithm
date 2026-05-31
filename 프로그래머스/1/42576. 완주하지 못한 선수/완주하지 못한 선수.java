import java.util.*;

// 22시 47분 시작
class Solution {
    public String solution(String[] participant, String[] completion) {
        // for문 2개는 시간초과라서 for문 내부에서 HashTable을 사용해서 O(1)로 접근해야 함
        
        Map<String, Integer> map = new HashMap<>();
        for (String str : completion) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        for (String str : participant) {
            if (map.getOrDefault(str, 0) == 0) {
                return str;
            }
            
            map.put(str, map.get(str) - 1);
            
        }
        return null;
    }
}