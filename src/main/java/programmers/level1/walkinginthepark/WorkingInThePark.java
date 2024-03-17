package programmers.level1.walkinginthepark;

import common.trigger.TestCaseInjectionTrigger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkingInThePark implements TestCaseInjectionTrigger {

    @Override
    public void trigger() {
        int[] result1 = solution(
                new String[]{"OSO","OOO","OXO","OOO"},
                new String[]{"E 2","S 3","W 1"});
        System.out.println(Arrays.toString(result1));
    }

    public int[] solution(String[] park, String[] routes) {
        Park parkArr = new Park(park);
        RobotDog robotDog = new RobotDog(parkArr.getStartPoint());
        for(String route : routes) {
            robotDog.moveByDirection(route, parkArr);
        }
        return robotDog.getCurrentPosition();
    }

    private static class RobotDog {

        private final int[] currentPosition;

        public RobotDog(int[] currentPosition) {
            this.currentPosition = currentPosition;
        }

        public int[] getCurrentPosition() {
            return currentPosition;
        }

        public void moveByDirection(String moveInfo, Park park) {
            String[] moveInfoArr = moveInfo.split(" ");
            String direction = moveInfoArr[0];
            int moveAmount = Integer.parseInt(moveInfoArr[1]);

            switch (direction) {
                case "E":
                    if (park.isEastMovable(this.currentPosition, moveAmount)) {
                        this.currentPosition[1] += moveAmount;
                    }
                    return;
                case "W":
                    if (park.isWestMovable(this.currentPosition, moveAmount)) {
                        this.currentPosition[1] -= moveAmount;
                    }
                    return;
                case "S":
                    if (park.isSouthMovable(this.currentPosition, moveAmount)) {
                        this.currentPosition[0] += moveAmount;
                    }
                    return;
                case "N":
                    if (park.isNorthMovable(this.currentPosition, moveAmount)) {
                        this.currentPosition[0] -= moveAmount;
                    }
            }
        }

    }

    private static class Park {

        private final List<List<String>> park = new ArrayList<>();

        private static final String START = "S";

        private static final String BLOCK = "X";

        private Park(String[] park) {
            for (String singleSpot : park) {
                this.park.add(Arrays.asList(singleSpot.split("")));
            }
        }

        public int[] getStartPoint() {
            int rowNum = 0;
            for (List<String> parkRow : park) {
                int columnIndex = parkRow.indexOf(START);
                if (columnIndex != -1) {
                    return new int[]{rowNum, columnIndex};
                }
                rowNum++;
            }
            return null;
        }

        public boolean isEastMovable(int[] currentPosition, int moveCount) {
            // 오른쪽으로 넘어가는 걍우.
            if (currentPosition[1] + moveCount > this.park.get(0).size()) {
                return false;
            }
            // X 가 있는 경우
            return this.park.get(currentPosition[0])
                    .subList(currentPosition[1], currentPosition[1] + moveCount)
                    .stream().noneMatch(column -> column.equals(BLOCK));
        }

        public boolean isWestMovable(int[] currentPosition, int moveCount) {
            if (currentPosition[1] - moveCount < 0) {
                return false;
            }

            return this.park.get(currentPosition[0])
                    .subList(currentPosition[1] - moveCount, currentPosition[1])
                    .stream().noneMatch(column -> column.equals(BLOCK));
        }

        public boolean isSouthMovable(int[] currentPosition, int moveCount) {
            if (currentPosition[0] + moveCount > this.park.size()) {
                return false;
            }
            return this.park.subList(currentPosition[0], currentPosition[0] + moveCount)
                    .stream().noneMatch(column -> column.get(currentPosition[1]).equals(BLOCK));
        }

        public boolean isNorthMovable(int[] currentPosition, int moveCount) {
            if (currentPosition[0] - moveCount < 0) {
                return false;
            }
            return this.park.subList(currentPosition[0] - moveCount, currentPosition[0])
                    .stream().noneMatch(column -> column.get(currentPosition[1]).equals(BLOCK));
        }
    }
}
