package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class PartNumber {

    @Test
    void answer() {
        System.out.println(solution("5525","1255"));
    }

    public String solution(String X, String Y) {
        List<Integer> pairedNumbers = new ArrayList<>();

        List<Character> xs = new ArrayList<>();
        Map<Character, Integer> yMap = new HashMap<>();

        for(char x : X.toCharArray()) {
            xs.add(x);
        }

        for(char y : Y.toCharArray()) {
            yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        }

        for(char x : xs) {
            if(yMap.containsKey(x) && yMap.get(x) > 0) {
                pairedNumbers.add(Character.getNumericValue(x));
                yMap.put(x, yMap.get(x) - 1);
            }
        }

        if(pairedNumbers.isEmpty()) return "-1";

        StringBuilder stringBuilder = new StringBuilder();

        pairedNumbers.sort(Collections.reverseOrder());

        if(pairedNumbers.get(0) == 0) return "0";

        pairedNumbers.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

}
