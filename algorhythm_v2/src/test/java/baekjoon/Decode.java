package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Decode {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            String cipherChunk = br.readLine().replaceAll(" ", "");
            Map<Character, Integer> characterMap = new HashMap<>();

            for (char cipherChar : cipherChunk.toCharArray()) {
                characterMap.put(cipherChar, characterMap.getOrDefault(cipherChar, 0) + 1);
            }

            int maxValue = 0;
            char answer = '?';

            for (char cipherChar : characterMap.keySet()) {
                int count = characterMap.get(cipherChar);
                if (count > maxValue) {
                    maxValue = count;
                    answer = cipherChar;
                } else if (count == maxValue) {
                    answer = '?';
                }
            }

            System.out.println(answer);
        }
    }

}
