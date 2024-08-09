class Solution {
    public boolean solution(int x) {
        int k = x;
        int sum = 0;
        while (k != 0) {
            sum += k % 10;
            k = k / 10;
        }
        boolean answer = true;
        if (x % sum != 0) answer = false;
        return answer;
    }
}