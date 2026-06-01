import java.util.*;

// 9시 10분 시작
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 아이디어:
        // 10일 차부터 각각의 날에 구매할 수 있는 품목을 확인할 수 있도록 저장.
        // for문을 돌면서 구매 품목 및 수량이 맞는지 확인.
        
        Map<String, Integer> wishList = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wishList.put(want[i], number[i]);
        }
        
        Map<String, Integer> discountList = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            discountList.put(discount[i], discountList.getOrDefault(discount[i], 0) + 1);
        }
        
        int answer = 0;
        int wishListSize = wishList.size();
        int cnt = 0;
        
        for (Map.Entry<String, Integer> entry : wishList.entrySet()) {
            String product = entry.getKey();
            Integer quantity = entry.getValue();
            
            if (discountList.getOrDefault(product, 0) != quantity) break;   
            cnt++;
        }
        if (wishListSize == cnt) answer++;
        
        
        for (int i = 10; i < discount.length; i++) {
            discountList.put(discount[i], discountList.getOrDefault(discount[i], 0) + 1);
            discountList.put(discount[i - 10], discountList.get(discount[i - 10]) - 1);
            
            int count = 0;
            for (Map.Entry<String, Integer> entry : wishList.entrySet()) {
                String product = entry.getKey();
                Integer quantity = entry.getValue();
                
                if (discountList.getOrDefault(product, 0) != quantity) break;
                
                count++;
            }
            
            if (wishListSize == count) answer++;
            
            
        }
        
        
        return answer;
    }
}