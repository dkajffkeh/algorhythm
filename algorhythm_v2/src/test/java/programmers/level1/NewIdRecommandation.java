package programmers.level1;

import java.util.Locale;
import org.junit.jupiter.api.Test;

public class NewIdRecommandation {

    @Test
    void init() {
        System.out.println(solution("123_.def"));
    }

    public String solution(String new_id) {

        String answer = step1(new_id);

        answer = step2(answer);

        answer = step3(answer);

        answer = step4(answer);

        // step5
        if(answer.length() == 0) {
            answer += "a";
        }

        answer = step6(answer);

        answer = step7(answer);

        return answer;
    }

    private String step1(String step0) {
        return step0.toLowerCase(Locale.ROOT);
    }

    private String step2(String step1) {
        char [] step2Arr = step1.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(char charArr : step2Arr) {
            if ((charArr >= 'a' && charArr <= 'z') || (charArr >= '0' && charArr <= '9') || charArr == '-' || charArr == '_' || charArr == '.') {
                stringBuilder.append(charArr);
            }
        }
        return stringBuilder.toString();
    }

    private String step3(String step2) {
        while (step2.contains("..")) {
            step2 = step2.replace("..", ".");
        }
        return step2;
    }

    private String step4(String step3) {
        if(step3.length() == 0) return step3;

        if(step3.charAt(0) == '.') {
            step3 = step3.substring(1);
        }

        if(step3.length() == 0) return step3;

        if (step3.charAt(step3.length() - 1) == '.') {
            step3 = step3.substring(0, step3.length() - 1);
        }

        return step3;
    }

    private String step6(String step5) {
        if(step5.length() < 16) return step5;

        step5 = step5.substring(0, 15);

        if (step5.charAt(step5.length() - 1) == '.') {
            step5 = step5.substring(0, step5.length() - 1);
        }

        return step5;
    }

    private String step7(String step6) {
        if(step6.length() > 2) return step6;

        char lastWord = step6.charAt(step6.length() - 1);

        StringBuilder step6Builder = new StringBuilder(step6);
        while(step6Builder.length() <= 2) {
            step6Builder.append(lastWord);
        }
        return step6Builder.toString();
    }
}
