class Solution {
    public String solution(String phone_number) {
        String[] str = phone_number.split("");

        String answer = "";
        for (int i = 0; i < str.length; i++) {
            if (i < str.length-4) answer += "*";
            else answer += str[i];
        }
        
        return answer;
    }
}