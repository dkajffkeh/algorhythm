package programmers.level1;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class Uniform {

    @Test
    void solTest() {
        System.out.println(solution(5, new int[]{1, 2}, new int[]{2, 3}));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Set<Integer> reserveSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> selfReservedCase = new HashSet<>();

        for (int r : reserve) {
            reserveSet.add(r);
        }
        for (int l : lost) {
            lostSet.add(l);
        }

        // 체육복을 도난 당했지만 여분이 있는 케이스
        for (int i = 1; i <= n; i++) {
            if (lostSet.contains(i) && reserveSet.contains(i)) {
                answer++;
                reserveSet.remove(i);
                lostSet.remove(i);
                selfReservedCase.add(i);
            }
        }

        for (int i = 1; i <= n; i++) {

            if (selfReservedCase.contains(i)) {
                continue;
            }

            // 체육복이 있는 케이스
            if (!lostSet.contains(i)) {
                answer++;
                continue;
            }

            // 나보다 작은녀석이 체육복이 있는 케이스
            if (reserveSet.contains(i - 1)) {
                answer++;
                reserveSet.remove(i - 1);
                continue;
            }

            if (reserveSet.contains(i + 1)) {
                answer++;
                reserveSet.remove(i + 1);
            }
        }

        return answer;
    }

}
