package programmers.level1;

import org.junit.jupiter.api.Test;

public class PiRoDo {

    static int count = 0;
    static int hp = 0;

    @Test
    void solTest() {
        System.out.println(solution(80, new int[][]{new int[]{80, 20}, new int[]{50, 40}, new int[]{30, 10}}));
    }

    public int solution(int k, int[][] dungeons) {
        hp = k;
        permute(dungeons, 0, dungeons.length -1);
        return count;
    }

    private void permute(int [][] dungeons, int start, int end) {
        if(start == end) {
            calc(dungeons, hp);
        } else {
            for (int i = start; i <= end; i++) {
                swap(dungeons, start, i);
                permute(dungeons, start + 1, end);
                swap(dungeons, start, i);
            }
        }
    }

    private void calc(int [][] dungeons, int health) {
        int loopCount = 0;
        for(int i = 0; i < dungeons.length; i++) {
            if(health >= dungeons[i][0]) {
                health -= dungeons[i][1];
                loopCount ++;
            }
        }
        count = Math.max(count, loopCount);
    }

    private void swap(int [][] dungeons, int a, int b) {
        int [] temp = dungeons[a];
        dungeons[a] = dungeons[b];
        dungeons[b] = temp;
    }

}
