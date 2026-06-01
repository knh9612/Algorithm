import java.util.*;

// 12시 10분 시작
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 많이 재생된 장르 순으로 저장
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<int[]>> musics = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);

            musics.putIfAbsent(genres[i], new ArrayList<>());
            musics.get(genres[i]).add(new int[]{i, plays[i]});
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));

        // 각 장르에서 상위 2개는 어떻게 찾고 고르지?
        // musics (genres, [index, plays])에서 plays 기준으로 내림차순 정렬
        for (List<int[]> musicList : musics.values()) {
            musicList.sort((a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];

                return b[1] - a[1];
            });
        }

        List<Integer> answer = new ArrayList<>();
        for (String genre : list) {
            List<int[]> musicList = musics.get(genre);
            int count = 0;
            for (int[] music : musicList) {
                if (++count > 2) break;

                answer.add(music[0]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}