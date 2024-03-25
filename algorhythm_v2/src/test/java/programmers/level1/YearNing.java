package programmers.level1;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class YearNing {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> yearningMap = new HashMap<>();
        for(int i = 0; i< name.length; i ++) {
            yearningMap.put(name[i], yearning[i]);
        }
        for(int i = 0; i< photo.length; i ++) {
            int sum = 0;
            for (String photoName : photo[i]) {
                sum += yearningMap.getOrDefault(photoName, 0);
            }
            answer[i] = sum;
        }
        return answer;
    }

}
