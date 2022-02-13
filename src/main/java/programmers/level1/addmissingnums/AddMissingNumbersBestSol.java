package programmers.level1.addmissingnums;

import common.trigger.TestCaseInjectionTrigger;


public class AddMissingNumbersBestSol implements TestCaseInjectionTrigger {

    @Override
    public void trigger() {
        System.out.println(solution(new int[]{1,2,3,4,6,7,8,0}));
        System.out.println(solution(new int[]{5,8,4,0,6,7,9}));
    }

    public int solution(int[] numbers) {
        int sum = addAllelements(9);
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }

    public int addAllelements(int maxNum){
        int totalNum = 0;
        for(int i = 1; i<=maxNum; i++){
            totalNum += i;
        }
        return totalNum;
    }


}
