import java.util.*;

// 11시 50분 시작
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 내가 신고한 사람과 그 사람의 신고 당한 횟수를 알아야 함.
        int n = id_list.length;
        Map<String, Integer> userInfoMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            userInfoMap.put(id_list[i], i);
        }
        
        // 신고 처리 - 동일 사람에 대해 중복 신고 불가
        int[] count = new int[n];
        Map<String, Node> map = new HashMap<>();
        
        for (String str : report) {
            String reporter = str.split(" ")[0];
            String user = str.split(" ")[1];
            
            Node node = map.getOrDefault(user, new Node());

            node.report(reporter);
            map.put(user, node);
        }
        
        // Node 중에서 reportCount가 k 이상인 것들을 찾고
        // set에 있는 이름의 index에 ++
        int[] answer = new int[n];
        
        for (Map.Entry<String, Node> entry : map.entrySet()) {
            Node node = entry.getValue();
            if (node.reportCount < k) continue;

            for (String reporter : node.reporterList) {
                answer[userInfoMap.get(reporter)]++;
            }

        }
        
        return answer;
    }
    
    class Node {
        int reportCount = 0;
        Set<String> reporterList = new HashSet<>();
                
        void report(String reporter) {
            if (reporterList.contains(reporter)) return;
            
            reporterList.add(reporter);
            reportCount++;
        }
        
   }
}