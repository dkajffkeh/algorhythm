package programmers.level1.notcompletionexpert;

import common.trigger.TestCaseInjectionTrigger;

import java.util.Arrays;

public class NotCompletionExpert implements TestCaseInjectionTrigger {

    @Override
    public void trigger() {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }

    public String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i<completion.length;i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[completion.length];
    }
}
