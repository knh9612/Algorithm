class Solution {
    public int solution(int[] numbers) {
        int[] k = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            k[numbers[i]]++;
        }
        int answer = 0;
        for (int i = 0; i < 10; i ++) {
            if (k[i] == 0) answer += i;
        }
        return answer;
    }
}