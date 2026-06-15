import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 동명이인이 있을 수 있기 때문에 해시테이블 사용
        // Map<String, Integer> -> (이름, 동명이인 수)
        Map<String, Integer> map = new HashMap<>();

        // 1. participant Map에 저장. O(N)
        for (String str : participant) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        // 2. completion 찾으면 -1. O(N)
        for (String str : completion) {
            map.put(str, map.get(str) - 1);
        }

        // 3. count 수가 0이 아닌 놈이 완주하지 못한 선수 O(N)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            } 
        }
        
        return "";
    }
}