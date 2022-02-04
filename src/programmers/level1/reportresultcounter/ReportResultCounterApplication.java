package programmers.level1.reportresultcounter;

import common.trigger.TestCaseInjectionTrigger;

import java.util.*;

public class ReportResultCounterApplication implements TestCaseInjectionTrigger {

    @Override
    public void trigger() {
        String [] id_list = {"con", "ryan"};
        String [] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    public int[] solution(String[]id_list, String[]report, int k) {

        int[] answer = new int[id_list.length];

        report = Arrays.stream(report).distinct().toArray(String[]::new); // 중복 제거

        Map<String, List<String>> reportParam = new HashMap<>();
        Map<String, Integer> reportedCountMap = new HashMap<>();


        for (String reportVal : report) {

            String[] rawReportInfo = reportVal.split(" ");
            String reportPerson = rawReportInfo[0];
            String reportedPerson = rawReportInfo[1];

            // 키값이 존재할 경우 그냥 add
            if (reportParam.containsKey(reportPerson)) {
                reportParam.get(reportPerson).add(reportedPerson);
            } else {
                // 키값이 존재하지 않을경우 new ArrayList 해준후 add 해줌
                reportParam.computeIfAbsent(reportPerson, value -> new ArrayList<>());
                reportParam.get(reportPerson).add(reportedPerson);
            }

            if (reportedCountMap.containsKey(reportedPerson)) {
                reportedCountMap.put(reportedPerson, reportedCountMap.get(reportedPerson) + 1);
            } else {
                reportedCountMap.computeIfAbsent(reportedPerson, value -> 1);
            }
        }

        for (String ids : id_list) {
            if (reportedCountMap.containsKey(ids) && (reportedCountMap.get(ids) < k)) {
                reportedCountMap.remove(ids);
            }
        }

        int answerIndex = 0;

        for (String id : id_list) {

            if (!reportParam.containsKey(id)) {
                answer[answerIndex] = 0;
            } else {
                List<String> reportedList = reportParam.get(id);
                Iterator<String> keys = reportedCountMap.keySet().iterator();

                while (keys.hasNext()) {
                    if (reportedList.contains(keys.next())) {
                        answer[answerIndex] += 1;
                    }
                    ;
                }
            }
            answerIndex += 1;

        }

        return answer;
    }
}
