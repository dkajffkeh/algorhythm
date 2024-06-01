package programmers.level1.dfs;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class Dfs {

    @Test
    void solution() {
        String[] alphabets = new String[]{"A", "B", "C", "D"};
        permute(alphabets, 0, alphabets.length - 1);
    }

    private void permute(String[] alphabets, int start, int end) {
        // 0, 3
        if (start == end) {
            System.out.println(Arrays.toString(alphabets));
        } else {
            for (int i = start; i <= end; i++) {
                swap(alphabets, start, i);
                permute(alphabets, start + 1, end);
                swap(alphabets, start, i);
            }
        }
    }

    private void swap(String[] alphabets, int a, int b) {
        String temp = alphabets[a];
        alphabets[a] = alphabets[b];
        alphabets[b] = temp;
    }
}
