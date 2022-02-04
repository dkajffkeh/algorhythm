package common;

import common.trigger.TestCaseInjectionTrigger;
import programmers.level1.lotteryminmax.LotteryGetMinMaxApplication;
import programmers.level1.reportresultcounter.ReportResultCounterApplication;

import java.util.Map;

public enum ProgrammersQuestionCode {

    LEVEL1_QUESTION_92334("신고 결과 받기","https://programmers.co.kr/learn/courses/30/lessons/92334",new ReportResultCounterApplication()),
    LEVEL1_QUESTION_77484("로또의 최고 순위와 최저 순위","https://programmers.co.kr/learn/courses/30/lessons/77484",new LotteryGetMinMaxApplication());

    private final String questionName;
    private final String questionURI;
    private final TestCaseInjectionTrigger caseInjectionTrigger;

    ProgrammersQuestionCode(String questionName,
                            String questionURI,
                            TestCaseInjectionTrigger caseInjectionTrigger) {
        this.questionName = questionName;
        this.questionURI = questionURI;
        this.caseInjectionTrigger = caseInjectionTrigger;
    }

    public String getQuestionName() {
        return questionName;
    }

    public String getQuestionURI() {
        return questionURI;
    }

    public TestCaseInjectionTrigger getCaseInjectionTrigger() {
        return caseInjectionTrigger;
    }
}
