package programmers.level1;


import org.junit.jupiter.api.Test;

public class EbayCodingTest {

    @Test
    void answer() {
        solution(new int[]{1, 4, 5, 2, 4}, new int[]{2, 4, 4, 3, 2});
    }

    void test1() {

    }

    public int[] solution(int[] truck, int[] w) {
        int[] answer = new int[w.length];

        // weight
        for (int i = 0; i < w.length; i++) {

            boolean isLoaded = false;

            for (int truckIndex = 0; truckIndex < truck.length; truckIndex++) {
                int maxWeight = truck[truckIndex];
                if (w[i] <= maxWeight) {
                    answer[i] = truckIndex + 1;
                    truck[truckIndex] -= w[i];
                    isLoaded = true;
                    break;
                }
            }

            if(!isLoaded) answer[i] = -1;
        }
        return answer;
    }

    void test3() {

    }
}
