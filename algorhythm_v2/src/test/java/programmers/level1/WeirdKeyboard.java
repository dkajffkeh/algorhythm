package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class WeirdKeyboard {

    @Test
    void solTest() {
        System.out.println(
                Arrays.toString(solution(new String[]{"AA"}, new String[]{"ABCD","AABB"})));
    }

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> minKeyValue = new HashMap<>();

        for (String keyChunk : keymap) {

            char[] singleKey = keyChunk.toCharArray();

            for (int i = 0; i < singleKey.length; i++) {

                if (!minKeyValue.containsKey(singleKey[i])) {
                    minKeyValue.put(singleKey[i], i + 1);
                } else {
                    int newValue = i + 1;
                    int prevValue = minKeyValue.get(singleKey[i]);
                    minKeyValue.put(singleKey[i], Math.min(prevValue, newValue));
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            for (char target : targets[i].toCharArray()) {
                if (!minKeyValue.containsKey(target)) {
                    count = -1;
                    break;
                }
                count += minKeyValue.get(target);
            }
            answer[i] = count;
        }

        return answer;
    }

}
