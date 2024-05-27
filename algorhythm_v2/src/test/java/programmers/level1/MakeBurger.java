package programmers.level1;

import org.junit.jupiter.api.Test;

public class MakeBurger {

    @Test
    void solutionTest() {
        System.out.println(solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1}));
    }

    public int solution(int[] ingredient) {
        int answer = 0;
        String popValue = "1231";

        StringBuilder stringBuilder = new StringBuilder();
        for(int singleIng: ingredient) {
            if(stringBuilder.length() < 4) {
                stringBuilder.append(singleIng);
            }

            stringBuilder.append(singleIng);
            
        }
        return answer;
    }
}
