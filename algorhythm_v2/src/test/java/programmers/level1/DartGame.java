package programmers.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class DartGame {

    @Test
    void solTest() {
        System.out.println(solution("9T2D3D#"));
    }

    public int solution(String dartResult) {
        String [] splitDarts = splitDartResult(dartResult);
        int [] result = new int[3];

        for(int i = 0; i < 3; i ++) {

            String number = "";
            int indexAnswer = 0;

            for(char dart : splitDarts[i].toCharArray()) {

                if(dart >= '0' && dart <= '9') {
                    number += String.valueOf(dart);
                    continue;
                }

                if(dart == 'S') {
                    indexAnswer = Integer.parseInt(number);
                    continue;
                }
                if(dart == 'D') {
                    indexAnswer = (int) Math.pow(Integer.parseInt(number), 2);
                    continue;
                }
                if(dart == 'T') {
                    indexAnswer = (int) Math.pow(Integer.parseInt(number), 3);
                    continue;
                }

                if(dart == '*'  && i > 0) {
                    result[i - 1] *= 2;
                    indexAnswer *= 2;
                    break;
                }

                if(dart == '*') {
                    indexAnswer *= 2;
                    break;
                }

                if(dart == '#') {
                    indexAnswer *= -1;
                    break;
                }

            }
            result[i] = indexAnswer;
        }

        return result[0] + result[1] + result[2];
    }

    private String[] splitDartResult(String dartResult) {
        List<String> resultList = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\d+[SDT][*#]?)");
        Matcher matcher = pattern.matcher(dartResult);
        while (matcher.find()) {
            resultList.add(matcher.group());
        }
        return resultList.toArray(new String[0]);
    }
}
