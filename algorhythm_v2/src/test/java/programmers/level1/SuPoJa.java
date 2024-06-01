package programmers.level1;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SuPoJa {

    @Test
    void solTest() {
        solution(new int[]{1,3,2,4,2});
    }

    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] one = new int[]{1, 2, 3, 4, 5};
        int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int oneCorrect = 0;
        int twoCorrect = 0;
        int threeCorrect = 0;

        for (int i = 0; i < answers.length; i++) {

            if(one[i % one.length] == answers[i]) {
                oneCorrect++;
            }

            if(two[i % two.length] == answers[i]) {
                twoCorrect++;
            }

            if(three[i % three.length] == answers[i]) {
                threeCorrect++;
            }
        }

        int max = Math.max(oneCorrect, Math.max(twoCorrect, threeCorrect));

        List<Integer> integers = new ArrayList<>();

        if(oneCorrect == max) integers.add(1);
        if(twoCorrect == max) integers.add(2);
        if(threeCorrect == max) integers.add(3);

        return integers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
