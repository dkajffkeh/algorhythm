package programmers.onestore;

import java.util.*;
import org.junit.jupiter.api.Test;

public class OneStoreCodingTest2 {

    @Test
    void solTest() {
        System.out.println(
                Arrays.toString(
                        solution(new int[]{1, 2, 3, 4, 5, 6}, new int[]{6, 2, 5, 1, 11})));
    }

    public int[] solution(int[] ball, int[] order) {
        List<Integer> answerList = new ArrayList<>();

        List<Integer> balls = new ArrayList<>();
        Queue<Integer> ordersQueue = new LinkedList<>();
        Map<Integer, Integer> blockingList = new HashMap<>();

        for (int singleBall : ball) {
            balls.add(singleBall);
        }

        for (int singleOrder : order) {
            ordersQueue.add(singleOrder);
        }

        while (balls.size() != 0) {
            if(ordersQueue.isEmpty()) break;

            int peekValue = ordersQueue.peek();

            if(balls.get(0) != peekValue && balls.get(balls.size() -1) != peekValue) {
                blockingList.put(ordersQueue.remove(), 0);
            }

            if(balls.get(0) == peekValue) {
                answerList.add(balls.get(0));
                balls.remove(0);
                ordersQueue.remove();

                if(balls.isEmpty()) break;

                while (blockingList.containsKey(balls.get(0))) {
                    int removeValue = balls.remove(0);
                    answerList.add(removeValue);
                    blockingList.remove(removeValue);
                }
            }

            if(balls.get(balls.size() - 1) == peekValue) {
                answerList.add(balls.get(balls.size() - 1));
                balls.remove(balls.size() - 1);
                ordersQueue.remove();

                if(balls.isEmpty()) break;

                while (blockingList.containsKey(balls.get(balls.size() - 1))) {
                    int removeValue = balls.remove(balls.size() - 1);
                    answerList.add(removeValue);
                    blockingList.remove(removeValue);
                }
            }
        }

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < ball.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

}
