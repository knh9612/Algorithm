class Solution
{
    public int solution(int n, int a, int b) {
        // 라운드 마다 부여 받은 번호를 기준으로 생각..!
        // 핵심 idea:
        // 1. 다음 라운드의 번호가 같다는 것은 두 참가자가 만났다는 것!
        // 2. 다음 라운드의 번호는 (이전 라운드의 번호 + 1) / 2

        int answer = 0;
        while (a != b) {
            answer++;
            
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;

    }
}