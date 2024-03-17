package programmers.level1.makeburger;

import common.trigger.TestCaseInjectionTrigger;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BurgerMaker implements TestCaseInjectionTrigger {

    @Override
    public void trigger() {

        System.out.println(solution(new int[] {1, 3, 2, 1, 2, 1, 3, 1, 2}));
        System.out.println(solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1}));

    }

    public int solution(int[] ingredient) {
        int answer = 0;
        String ingredientsArr = Arrays.stream(ingredient)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        String properBurgerElement = "1231";

        for(int i = 0 ; i < ingredientsArr.length() - 3 ; i ++) {

            if(ingredientsArr.substring(i,i+4).equals(properBurgerElement)) answer ++;

        }

        return answer;
    }
}
