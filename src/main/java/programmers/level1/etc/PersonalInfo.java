package programmers.level1.etc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PersonalInfo {

    public PersonalInfo() {
        solution("2022.05.19"
                , new String[]{"A 6", "B 12", "C 3"}
                ,new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        String[] todayArr = today.split("\\.");
        LocalDate standard = LocalDate.of(
                Integer.parseInt(todayArr[0]),
                Integer.parseInt(todayArr[1]),
                Integer.parseInt(todayArr[2]));

        Map<String, Integer> termsMap = new HashMap<>();

        for(String term : terms) {
            String [] termArr = term.split(" ");
            termsMap.put(termArr[0], Integer.parseInt(termArr[1]));
        }

        ArrayList<Integer> expiredIndex = new ArrayList<>();

        for(int i = 0 ; i < privacies.length; i ++) {
            String dateString = privacies[i].split(" ")[0];
            String termCode = privacies[i].split(" ")[1];

            LocalDate createdDate = toLocalDate(dateString);
            LocalDate expirationDate = expirationDate(termsMap.get(termCode), createdDate);

            if(expirationDate.isBefore(standard)) {
                expiredIndex.add(i+1);
            }
        }

        return expiredIndex.stream().mapToInt(Integer::intValue).toArray();
    }

    private static LocalDate expirationDate(int month, LocalDate createdDate) {
        if(createdDate.getDayOfMonth() == 1) {
            LocalDate kakaoYear = createdDate.plusMonths(month - 1);
            return LocalDate.of(kakaoYear.getYear(), kakaoYear.getMonthValue(), 28);
        }
        LocalDate kakaoYear = createdDate.plusMonths(month);
        return LocalDate.of(kakaoYear.getYear(), kakaoYear.getMonthValue(), kakaoYear.getDayOfMonth() - 1);
    }

    private static LocalDate toLocalDate(String expirationDate) {
        String[] expirationDateArr = expirationDate.split("\\.");
        return LocalDate.of(
                Integer.parseInt(expirationDateArr[0]),
                Integer.parseInt(expirationDateArr[1]),
                Integer.parseInt(expirationDateArr[2]));
    }

}
