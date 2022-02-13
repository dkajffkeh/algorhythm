package programmers.level1.lotteryminmax;

import common.trigger.TestCaseInjectionTrigger;

import java.util.Arrays;

public class LotteryGetMinMaxApplication implements TestCaseInjectionTrigger {
    @Override
    public void trigger() {
        System.out.println(Arrays.toString(solution(new int [] {44, 1, 0, 0, 31, 25}, new int [] {31, 10, 45, 1, 6, 19})));
        System.out.println(Arrays.toString(solution(new int [] {0, 0, 0, 0, 0, 0}, new int [] {38, 19, 20, 40, 15, 25})));
        System.out.println(Arrays.toString(solution(new int [] {45, 4, 35, 20, 3, 9}, new int [] {20, 9, 3, 45, 4, 35})));
    }

    public int[] solution(int[] lottos, int[] win_nums){

        int[] winnerPlaceArr = new int[]{0,6,5,4,3,2,1};

        // 0이 몇개인지
        int zeroValue = countZeroValue(lottos);
        int winNumber = winNumberPicker(lottos,win_nums);

        int maxPlace = zeroValue+winNumber == 0 ? 1 : zeroValue+winNumber;
        int minPlace = winNumber == 0 ? 1 : winNumber;

        return new int[]{winnerPlaceArr[maxPlace],winnerPlaceArr[minPlace]};
    }

    public int countZeroValue(int [] lottos){
        return (int)Arrays.stream(lottos).filter(lotto -> lotto == 0).count();
    }

    public int winNumberPicker(int[] lottos, int[] win_nums){

        int winNumberCounter = 0;
        int [] clonedLottos = Arrays.stream(lottos).filter(lotto -> lotto > 0).toArray().clone();

        for(int lotto : clonedLottos){
            for (int winNum : win_nums){
                if(winNum == lotto){
                    winNumberCounter += 1;
                    break;
                }
            }
        }
        return winNumberCounter;
    }
}
