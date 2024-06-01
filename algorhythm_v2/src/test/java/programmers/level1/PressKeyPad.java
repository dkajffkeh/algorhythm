package programmers.level1;

import org.junit.jupiter.api.Test;

public class PressKeyPad {

    @Test
    void solTest() {
        System.out.println(solution(new int []{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }

    public String solution(int[] numbers, String hand) {

        int leftPosition = 10;
        int rightPosition = 12;

        StringBuilder builder = new StringBuilder();

        for (int number : numbers) {

            if(number == 0) number = 11;

            if (number == 1 || number == 4 || number == 7) {
                builder.append("L");
                leftPosition = number;
                continue;
            }

            if (number == 3 || number == 6 || number == 9) {
                builder.append("R");
                rightPosition = number;
                continue;
            }

            int leftAbs = Math.abs(leftPosition - number);
            int rightAbs = Math.abs(rightPosition - number);

            int leftLength = (leftAbs / 3) + (leftAbs % 3);
            int rightLength = (rightAbs / 3) + (rightAbs % 3);

            if (leftLength == rightLength) {
                if(hand.equals("right")) {
                    builder.append("R");
                    rightPosition = number;
                } else {
                    builder.append("L");
                    leftPosition = number;
                }
                continue;
            }

            if (leftLength > rightLength) {
                builder.append("R");
                rightPosition = number;
                continue;
            }

            builder.append("L");
            leftPosition = number;
        }

        return builder.toString();
    }



}
