package common;

import common.trigger.TestCaseInjectionTrigger;
import common.type.YnType;
import leetcode.level1.IsoMorphicString;
import programmers.level1.addmissingnums.AddMissingNumbers;
import programmers.level1.bandage.Bandage;
import programmers.level1.keypad.PressingKeypads;
import programmers.level1.lotteryminmax.LotteryGetMinMaxApplication;
import programmers.level1.makeburger.BurgerMaker;
import programmers.level1.notcompletionexpert.NotCompletionExpert;
import programmers.level1.present.PresentGivenTheMost;
import programmers.level1.reportresultcounter.ReportResultCounterApplication;
import programmers.level1.stringandwords.StringAndWords;
import programmers.level1.walkinginthepark.WorkingInThePark;

import static common.type.YnType.N;
import static common.type.YnType.Y;

public enum ProgrammersQuestionCode {

    LEVEL1_QUESTION_92334(
            "[신고 결과 받기]"
            ,"https://programmers.co.kr/learn/courses/30/lessons/92334"
            , Y
            ,new ReportResultCounterApplication()),

    LEVEL1_QUESTION_77484(
            "[로또의 최고 순위와 최저 순위]"
            ,"https://programmers.co.kr/learn/courses/30/lessons/77484"
            , Y
            ,new LotteryGetMinMaxApplication()),

    LEVEL1_QUESTION_81301(
            "[숫자 문자열과 영단어]"
            ,"https://programmers.co.kr/learn/courses/30/lessons/81301"
            , Y
            ,new StringAndWords()),

    LEVEL1_QUESTION_67256(
            "[키패드 누르기]"
            ,"https://programmers.co.kr/learn/courses/30/lessons/67256"
            , N
            ,new PressingKeypads()),

    LEVEL1_QUESTION_86051(
            "[없는 숫자 더하기]"
            ,"https://programmers.co.kr/learn/courses/30/lessons/86051"
            , Y
            ,new AddMissingNumbers()),

    LEVEL1_QUESTION_42576(
            "[완주하지 못한 선수]"
            ,"https://programmers.co.kr/learn/courses/30/lessons/42576"
            , Y
            ,new NotCompletionExpert()),

    LEVEL1_QUESTION_133502(
            "[햄버거 만들기]"
            ,"https://school.programmers.co.kr/learn/courses/30/lessons/133502?language=java"
            , Y
            ,new BurgerMaker()),

    ISOMORPHIC_STRING(
            "[Isomorphic Strings]"
            ,"https://leetcode.com/problems/isomorphic-strings/?envType=study-plan&id=level-1"
            , Y
            ,new IsoMorphicString()),

    LEVEL1_QUESTION_25872(
            "[가장 많이 받은 선물]"
            ,"https://school.programmers.co.kr/learn/courses/30/lessons/258712?language=java"
            , Y
            ,new PresentGivenTheMost()),

    LEVEL1_QUESTION_250137(
            "[PCCP 기출문제] 1번 / 붕대 감기"
            ,"https://school.programmers.co.kr/learn/courses/30/lessons/250137"
            , Y
            ,new Bandage()),

    LEVEL1_QUESTION_172928(
            "공원산책"
            ,"https://school.programmers.co.kr/learn/courses/30/lessons/250137"
            , Y
            ,new WorkingInThePark()),
    ;


    private final String questionName;
    private final String questionURI;

    private final YnType completeYn;
    private final TestCaseInjectionTrigger caseInjectionTrigger;



    ProgrammersQuestionCode(String questionName,
                            String questionURI,
                            YnType completeYn,
                            TestCaseInjectionTrigger caseInjectionTrigger) {
        this.questionName = questionName;
        this.questionURI = questionURI;
        this.completeYn=completeYn;
        this.caseInjectionTrigger = caseInjectionTrigger;
    }

    public String getQuestionName() {
        return questionName;
    }

    public String getQuestionURI() {
        return questionURI;
    }

    public YnType getCompleteYn() {
        return completeYn;
    }

    public TestCaseInjectionTrigger getCaseInjectionTrigger() {
        return caseInjectionTrigger;
    }
}
