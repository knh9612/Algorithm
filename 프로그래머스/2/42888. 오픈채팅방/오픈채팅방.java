import java.util.*;
// 11시 10분 시작
class Solution {
    public String[] solution(String[] record) {
        // 아이디어:
        // 유저 아이디, 닉네임을 Map에 저장
        Map<String, String> users = new HashMap<>();
        
        List<Map<String, String>> userActions = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
            String[] userInfo = record[i].split(" ");
            String action = userInfo[0];
            String userId = userInfo[1];
            
            // Enter, Change의 경우 유저 정보 저장 or 업데이트 (유저 아이디, 닉네임)
            if (!action.equals("Leave")) {
                String nickname = userInfo[2];
                users.put(userId, nickname);
            }
            
            // Enter, Leave만 action 저장
            if (!action.equals("Change")) {
                Map<String, String> map = new HashMap<>();
                map.put(action, userId);
                userActions.add(map);
            }
            
        }
        
        String[] answer = new String[userActions.size()];
        int i = 0;
        for (Map<String, String> actionMap : userActions) {
            for (Map.Entry<String, String> entry : actionMap.entrySet()) {
                String action = entry.getKey();
                String userId = entry.getValue();
                String nickname = users.get(userId);
                
                if (action.equals("Enter")) {
                    answer[i] = nickname + "님이 들어왔습니다.";
                    
                } else {
                    answer[i] = nickname + "님이 나갔습니다.";
                }
                i++;
            }
        }
        
        return answer;
    }
}