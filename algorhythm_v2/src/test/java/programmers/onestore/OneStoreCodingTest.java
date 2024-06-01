package programmers.onestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class OneStoreCodingTest {

    @Test
    void solTest() {
        System.out.println(solution(new String[]{"BCD", "ABB", "FEE"}));
    }

    public int solution(String [] scores) {
        int answer = 0;

        List<String> filteredList = new ArrayList<>();
        // F 2개 필터
        filterFailDevelopers(scores, filteredList);
        // A 를 2개 이상 받은 합격자
        answer += getDoubleADevelopersCount(filteredList);

        answer += finalConditionDevelopers(filteredList);

        return answer;
    }

    private void filterFailDevelopers(String [] scores, List<String> filteredList) {
        for (String s : scores) {
            int fCount = 0;
            for (char c : s.toCharArray()) {
                if (c == 'F') {
                    fCount++;
                }
            }
            if (fCount < 2) {
                filteredList.add(s);
            }
        }
    }

    private int getDoubleADevelopersCount(List<String> filteredList) {
        int doubleACount = 0;

        for (int i = 0; i < filteredList.size(); i++) {
            int aCount = 0;
            for(char score : filteredList.get(i).toCharArray()){
                if (score == 'A') {
                    aCount++;
                }
            }
            if(aCount >= 2) {
                doubleACount++;
                filteredList.remove(i);
            }
        }

        return doubleACount;
    }

    private int finalConditionDevelopers(List<String> filteredList) {

        Map<Character, Integer> scoreMap = buildScoreMap();

        int winningDevelopers = 0;

        for(String scores : filteredList) {
            int max = 0;
            int min = 0;
            int totalScore = 0;
            for(char singleScore : scores.toCharArray()) {

                int scoreCount = scoreMap.get(singleScore);

                max = Math.max(scoreCount, max);
                if(min == 0) {
                    min = scoreCount;
                } else {
                    min = Math.min(scoreCount, min);
                }
                totalScore += scoreCount;
            }

            totalScore = totalScore - max - min;
            double result = (double) totalScore / (scores.length() - 2);

            if(result >= 3) winningDevelopers ++;
        }
        return winningDevelopers;
    }

    private Map<Character, Integer> buildScoreMap() {
        Map<Character, Integer> scoresMap = new HashMap<>();
        scoresMap.put('A', 5);
        scoresMap.put('B', 4);
        scoresMap.put('C', 3);
        scoresMap.put('D', 2);
        scoresMap.put('E', 1);
        scoresMap.put('F', 0);
        return scoresMap;
    }

    public static void main(String[] args) {
        System.out.println((double)15/4);
    }
}
