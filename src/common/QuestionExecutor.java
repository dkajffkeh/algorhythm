package common;

import common.trigger.TestCaseInjectionTrigger;

import java.lang.reflect.InvocationTargetException;

public class QuestionExecutor {

    private QuestionExecutor(){}

    public static void executor(ProgrammersQuestionCode questionCode){

        TestCaseInjectionTrigger caseInjectionTrigger = questionCode.getCaseInjectionTrigger();
        try {
            caseInjectionTrigger.getClass().getMethod("trigger").invoke(caseInjectionTrigger);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
