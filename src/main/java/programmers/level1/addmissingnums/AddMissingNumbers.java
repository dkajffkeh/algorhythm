package programmers.level1.addmissingnums;

import common.trigger.TestCaseInjectionTrigger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddMissingNumbers implements TestCaseInjectionTrigger {

    @Override
    public void trigger() {
        System.out.println(solution(new int[]{1,2,3,4,6,7,8,0}));
        System.out.println(solution(new int[]{5,8,4,0,6,7,9}));
    }

    public int solution(int[] numbers) {

        // 1~9
        List<Integer> answerNums = new ArrayList<>();
        answerNums = setDefaultNums(answerNums);

        // param 배열
        List<Integer> toBeDeletedNums = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        return answerNums.stream().filter(num -> {
            if (toBeDeletedNums.contains(num)) return false;
            return true;
        }).mapToInt(num -> num).sum();
    }

    public List<Integer> setDefaultNums(List<Integer> arrayParam){
        for(int i = 1; i<10; i++){
            arrayParam.add(i);
        }
        return arrayParam;
    }

}
