package programmers.level1.stringandwords;

import common.trigger.TestCaseInjectionTrigger;

public class StringAndWords implements TestCaseInjectionTrigger {

    @Override
    public void trigger() {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("123"));
    }

    public int solution(String s) {
        final String [] englishNumbers = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < englishNumbers.length; i++) {
            s = s.replaceAll(englishNumbers[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}
