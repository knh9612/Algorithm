import java.util.*;

class Solution {
    /*
        <문제 요구사항>
        1. 코스요리 메뉴 구성을 문자열 형태로 배열에 담아 return
        2. 정답 배열은 오름차순 정렬
        3. 최소 2명 이상의 손님들이 주문한 메뉴들로 코스요리 메뉴 구성
    */
    static Map<Integer, Map<String, Integer>> map;

    public String[] solution(String[] orders, int[] course) {
        // 필요한 자료구조는?
        // (r, ArrayList<String>) -> (몇 개를 선택해야 하는지를 key로, key를 선택하는 조합들을 ArrayList<String> 에 저장)
        // 다만, 조합들이 몇 번씩 나오는지 개수를 세야하므로 (r, HashMap<String, Integer>)로 수정.
        // 즉, (r, (r개를 선택하는 조합, 카운트))

        map = new HashMap<>();

        // course를 돌면서 n개 인식
        for (int r : course) {
            map.computeIfAbsent(r, k -> new HashMap<>());

            // orders를 돌면서 손님들이 주문한 메뉴 구성 중 n개를 선택하는 조합들을 저장
            for (String order : orders) {
                char[] orderedMenus = order.toCharArray();
                Arrays.sort(orderedMenus);

                backtrack(0, r, orderedMenus, "");
            }
        }
        
        // 조합들 중 count가 2 이상인 것들 중 가장 큰 count만 정답 배열에 담아 return
        List<String> answer = new ArrayList<>();
        for (int n : course) {
            int maxCount = -1;

            for (Map.Entry<String, Integer> entry : map.get(n).entrySet()) {
                maxCount = Math.max(entry.getValue(), maxCount);
            }

            if (maxCount < 2)  continue;

            for (Map.Entry<String, Integer> entry : map.get(n).entrySet()) {
                if (entry.getValue() == maxCount) {
                    answer.add(entry.getKey());
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }

    // 조합 함수
    private static void backtrack(int start, int r, char[] orderedMenus, String cur) {
        // 종료 조건은? 현재 개수가 r일 때
        if (cur.length() == r) {
            map.get(r).put(cur, map.get(r).getOrDefault(cur, 0) + 1);
            return;
        }

        for (int i = start; i < orderedMenus.length; i++) {
            backtrack(i + 1, r, orderedMenus, cur +  orderedMenus[i]);
        }
    }
}