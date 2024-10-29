package voithru;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class VoithruCodingTest {

    @Test
    void solution(int[][] monsters, int[][] bullets) {
        Stack<Integer[]> magazine = new Stack<>();

        for (int[] bullet : bullets) {
            magazine.push(new Integer[] {bullet[0], bullet[1]});
        }



    }

    @Test
    void divideTest() {
    }
}
