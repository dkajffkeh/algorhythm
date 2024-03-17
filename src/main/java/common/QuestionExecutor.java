package common;

import common.trigger.TestCaseInjectionTrigger;

public class QuestionExecutor {

    private QuestionExecutor(){}

    public static void executor(ProgrammersQuestionCode questionCode){

        TestCaseInjectionTrigger caseInjectionTrigger = questionCode.getCaseInjectionTrigger();
        try {
            System.out.println();
            System.out.println(questionCode.getQuestionURI());
            System.out.println(questionCode.getQuestionName());
            caseInjectionTrigger.getClass().getMethod("trigger").invoke(caseInjectionTrigger);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
