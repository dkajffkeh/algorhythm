package programmers.level1;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MakeBurger {

    @Test
    void solutionTest() {
        System.out.println(solution(new int[]{1,2,3,1}));
    }

    public int solution(int[] ingredient) {
        int answer = 0;

        List<Integer> burgerIndex = new ArrayList<>();

        for (int singleIngredient : ingredient) {

            burgerIndex.add(singleIngredient);

            while (true) {
                if (burgerIndex.size() < 4) {
                    break;
                }
                if (burgerIndex.get(burgerIndex.size() - 1) == 1 &&
                        burgerIndex.get(burgerIndex.size() - 2) == 3 &&
                        burgerIndex.get(burgerIndex.size() - 3) == 2 &&
                        burgerIndex.get(burgerIndex.size() - 4) == 1) {
                    answer ++;
                    burgerIndex.remove(burgerIndex.size() - 1);
                    burgerIndex.remove(burgerIndex.size() - 1);
                    burgerIndex.remove(burgerIndex.size() - 1);
                    burgerIndex.remove(burgerIndex.size() - 1);
                } else {
                    break;
                }
            }

        }

        return answer;
    }
}
