package programmers.level1;

import org.junit.jupiter.api.Test;

public class BabblingTwo {

    @Test
    void solTest() {
        System.out.println(solution(new String[]{"mawooma"}));
    }

    public int solution(String[] babbling) {
        int answer = 0;

        for(String str : babbling) {

            if(str.contains("ayaaya") || str.contains("yeye") || str.contains("woowoo") || str.contains("mama")) {
                continue;
            }

            str = str.replace("aya", " ");
            str = str.replace("ye", " ");
            str = str.replace("woo", " ");
            str = str.replace("ma", " ");
            str = str.replace(" ", "");

            if(str.length() == 0) answer++;
        }

        return answer;
    }

}
