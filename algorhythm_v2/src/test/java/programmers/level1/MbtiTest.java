package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class MbtiTest {

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        Map<String, Integer> resultMap = createDefaultScoreMap();
        int [] scores = new int[]{3,2,1,0,1,2,3};
        for(int i = 0; i < survey.length; i++) {

            if(choices[i] == 4) continue;

            String type = "";

            if(choices[i] < 4) {
                type = survey[i].split("")[0];
            }
            if(choices[i] > 4) {
                type = survey[i].split("")[1];
            }

            int score = scores[choices[i]];
            resultMap.put(type, resultMap.get(type) + score);
        }

        answer += resultBuilder(resultMap, "R", "T");
        answer += resultBuilder(resultMap, "C", "F");
        answer += resultBuilder(resultMap, "J", "M");
        answer += resultBuilder(resultMap, "A", "N");

        return answer;
    }

    private String resultBuilder(Map<String, Integer> resultMap, String key1, String key2) {
        int score1 = resultMap.get(key1);
        int score2 = resultMap.get(key2);

        if(score1 == score2) return key1;

        return score1 > score2 ? key1 : key2;
    }

    private Map<String, Integer> createDefaultScoreMap() {
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("R", 0);
        resultMap.put("T", 0);
        resultMap.put("C", 0);
        resultMap.put("F", 0);
        resultMap.put("J", 0);
        resultMap.put("M", 0);
        resultMap.put("A", 0);
        resultMap.put("N", 0);
        return resultMap;
    }


}
