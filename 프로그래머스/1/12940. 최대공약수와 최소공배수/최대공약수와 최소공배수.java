class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n, m);
        answer[1] = (n*m)/answer[0];
        return answer;
    }
    
    public int gcd(int a, int b) {
        if (a < b) swap(a, b); // 더 큰 수는 a
        int r = a % b;
        if (r != 0) return gcd(b, r);
        else return b;
        
    }
    
    public void swap(int a, int b) {
        int temp = b;
        b = a;
        a = temp;
    }
}