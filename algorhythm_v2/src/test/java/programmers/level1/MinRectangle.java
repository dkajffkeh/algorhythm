package programmers.level1;

import org.junit.jupiter.api.Test;

public class MinRectangle {

    @Test
    void solTest() {
        System.out.println(solution(new int[][]{new int[]{60, 50}, new int[]{30, 70}, new int[]{60, 30}, new int[]{80, 40}}));
    }

    public int solution(int[][] sizes) {
        int height = 0;
        int width = 0;

        for(int i = 0; i < sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);

            if(height < max) {
                height = max;
            }

            if(width < min) {
                width = min;
            }
        }
        return height * width;
    }
}
