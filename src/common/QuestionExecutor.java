package common;

import common.trigger.TestCaseInjectionTrigger;

import java.lang.reflect.InvocationTargetException;

public class QuestionExecutor {

    private QuestionExecutor(){}

    public static void executor(ProgrammersQuestionCode questionCode){

        TestCaseInjectionTrigger trigger = questionCode.getCaseInjectionTrigger();
        try {
            trigger.getClass().getMethod("trigger").invoke(trigger);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
