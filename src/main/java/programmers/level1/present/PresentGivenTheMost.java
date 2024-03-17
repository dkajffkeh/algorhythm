package programmers.level1.present;

import common.trigger.TestCaseInjectionTrigger;
import java.util.HashMap;
import java.util.Map;

public class PresentGivenTheMost implements TestCaseInjectionTrigger {

    @Override
    public void trigger() {
        int result1 = solution(new String[]{"muzi", "ryan", "frodo", "neo"},
                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"});
        System.out.println(result1);
        int result2 = solution(new String[]{"joy", "brad", "alessandro", "conan", "david"},
                new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"});
        System.out.println(result2);
        int result3 = solution(new String[]{"a", "b", "c"},
                new String[]{"a b", "b a", "c a", "a c", "a c", "c a"});
        System.out.println(result3);
    }

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> indexMap = new HashMap<>();
        Map<String, Integer> giveAndTakeMap = new HashMap<>();
        for (String gift : gifts) {
            String[] giverAndTaker = gift.split(" ");
            String giver = giverAndTaker[0];
            String taker = giverAndTaker[1];
            calculatePresentIndex(giver, taker, indexMap);
            giveAndTakeMap.compute(gift, (k, v) -> (v == null)? 1 : v + 1);
        }

        for(String giver : friends) {

            int nextMonthPresents = 0;

            for(String taker : friends) {
                if(giver.equals(taker)) continue;

                String givenInfo = giver + " " + taker;
                String takenInfo = taker + " " + giver;

                int givenCount = giveAndTakeMap.getOrDefault(givenInfo, 0);
                int takenCount = giveAndTakeMap.getOrDefault(takenInfo, 0);

                if(givenCount > takenCount) nextMonthPresents++;

                if(givenCount == takenCount) {
                    if(indexMap.getOrDefault(giver, 0) > indexMap.getOrDefault(taker, 0)) {
                        nextMonthPresents++;
                    }
                }

                if(nextMonthPresents > answer) {
                    answer = nextMonthPresents;
                }
            }

        }

        return answer;
    }

    private static void calculatePresentIndex(
            String giver,
            String taker,
            Map<String, Integer> indexMap
    ) {
        indexMap.compute(giver, (k, v) -> v == null ? 1 : indexMap.get(giver) + 1 );
        indexMap.compute(taker, (k, v) -> v == null ? -1 : indexMap.get(taker) - 1 );
    }

}
