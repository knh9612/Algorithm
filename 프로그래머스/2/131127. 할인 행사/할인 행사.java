import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // discount[0]부터 discount[discount.length - 10]까지 돌면서
        // 1. 각 날짜부터 10일 간 살 수 있는 품목들을 저장.
        // Map<Integer, Map<String, Integer> -> (index, (product, count))
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        for (int i = 0; i <= discount.length - 10; i++) {
            map.put(i, new HashMap<>());
            for (int j = i; j < i + 10; j++) {
                map.get(i).put(discount[j], map.get(i).getOrDefault(discount[j], 0) + 1);
            }
        }

        // 2. 위에서 저장한 map을 돌면서 wishList의 수량과 맞는지 확인하면서 count
        int answer = 0;
        A: for (Map.Entry<Integer, Map<String, Integer>> entry : map.entrySet()) {
            Map<String, Integer> discountList = entry.getValue();
            for (int i = 0; i < want.length; i++) {
                String product = want[i];
                int count = number[i];

                if (!discountList.containsKey(want[i]) || discountList.get(product) != count) continue A;
            }

            answer++;
        }

        return answer;
    }
}