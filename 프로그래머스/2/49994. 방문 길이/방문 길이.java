import java.util.*;

class Solution {
    private static final HashMap<Character, int[]> directions = new HashMap<>();
    
    private static void initDirection() {
        directions.put('U', new int[]{0, 1});
        directions.put('D', new int[]{0, -1});
        directions.put('L', new int[]{-1, 0});
        directions.put('R', new int[]{1, 0});
    }
    
    public int solution(String dirs) {
        initDirection();
        int cx = 5;
        int cy = 5;
        
        HashSet<String> answer = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = directions.get(dirs.charAt(i));
            int nx = cx + offset[0];
            int ny = cy + offset[1];
            
            if (0 <= nx && nx <= 10 && 0 <= ny && ny <= 10) {
                answer.add(cx + " " + cy + " " + nx + " " + ny);
                answer.add(nx + " " + ny + " " + cx + " " + cy);
                
                cx = nx;
                cy = ny;
            }
            
        }
        
        return answer.size() / 2;
    }
}