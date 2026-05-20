// 21시 55분 시작
import java.util.*;

// 문제 해석
// 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
// 즉, stages에 담긴 stage의 수(A) / stages에 담긴 stage 중 A 보다 크거나 같은 수의 합

// N+1? 아 마지막 스테이지까지 클리어한 사용자. ㅇㅋ.

// 실패율이 높은 스테이지부터 내림차순으로 return
class Solution {
    public List<Integer> solution(int N, int[] stages) {
        double[] failRates = new double[N];
        
        // 이중 for문을 돌면서 실패율 계산
        for (int i = 1; i <= N; i++) {
            int fail = 0;
            int reach = 0;
            
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) fail++;
                if (stages[j] >= i) reach++;
            }
            
            if (reach != 0) {
                failRates[i - 1] = (double) fail / reach;
                
            }
            
        }
        
        // 실패율이 높은 스테이지 번호부터 반환(내림차순 정렬)
        // 스테이지 번호 저장
        List<Integer> answer = new ArrayList<>();
        double max = -1;
        
        for (int i = 0; i < N; i++) {
            // max 찾고
            for (int j = 0; j < N; j++) {
                if (failRates[j] > max) max = failRates[j];
            }

            // answer 배열에 추가
            for (int j = 0; j < N; j++) {
                if (max == failRates[j]) {
                    answer.add(j + 1);
                    failRates[j] = -2;
                }
                
            }
            // max 초기화 등
            max = -1;
            
        }


        return answer;
    }
    
}