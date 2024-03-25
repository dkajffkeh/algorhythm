package programmers.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoughKeyboard {

    @Test
    void answer() {
        System.out.println(Arrays.toString(solution(new String[]{"AA"}, new String[]{"B"})));
    }

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
         Map<String, Integer> shortCutMap = new HashMap<>();
         for(String keyChunk : keymap) {

             String[] keys = keyChunk.split("");

             for(int i = 0; i < keys.length; i++) {
                 if(!shortCutMap.containsKey(keys[i])) {
                     shortCutMap.put(keys[i], i + 1);
                     continue;
                 }

                 if(shortCutMap.get(keys[i]) > i + 1) {
                     shortCutMap.put(keys[i], i + 1);
                 }
             }
         }

         for(int i = 0; i<targets.length; i ++) {
            String[] targetArr = targets[i].split("");
            int sum = 0;

            for(String target: targetArr) {
                if(!shortCutMap.containsKey(target)) {
                    return new int[]{-1};
                }
                sum += shortCutMap.get(target);
            }
            answer[i] = sum;
         }

        return answer;
    }
}

// SUBSTR(A.CREATED_DATE,1,7) = '2022-10'
// DATE_FORMAT(B.CREATED_DATE, '%Y-%m-%d')
