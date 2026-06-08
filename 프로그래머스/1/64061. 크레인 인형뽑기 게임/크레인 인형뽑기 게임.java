import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 2차원 배열을 (index, stack)의 map으로 변환
        Map<Integer, Deque<Integer>> map = new HashMap<>();

        int rowLength = board.length;
        int columnLength = board[0].length;

        for (int i = 0; i < columnLength; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = rowLength - 1; j >= 0; j--) {
                if (board[j][i] == 0) continue;

                stack.push(board[j][i]);
            }
            map.put(i + 1,  stack);
        }

        // moves에 따라 인형 뽑기 진행
        // 인형 뽑기 시 사라진 인형 개수 count
        Deque<Integer> bucket = new ArrayDeque<>();
        int answer = 0;
        for (int move : moves) {
            Deque<Integer> stack = map.get(move);
            if (stack.isEmpty()) continue;

            int input = stack.pop();
            if (!bucket.isEmpty() && bucket.peek() == input) {
                bucket.pop();
                answer += 2;

            } else {
                bucket.push(input);
            }
        }
        
        return answer;

    }
}