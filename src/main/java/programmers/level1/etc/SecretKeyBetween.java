package programmers.level1.etc;

import java.util.HashMap;
import java.util.Map;

public class SecretKeyBetween {

    public SecretKeyBetween() {
        System.out.println(solution("z","awbqd", 1));
    }

    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }
            answer.append(temp);
        }

        return answer.toString();
    }

}
