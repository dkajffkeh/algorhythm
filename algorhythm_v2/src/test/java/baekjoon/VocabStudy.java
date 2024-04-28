package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class VocabStudy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (input == null || input.equals("")) {
            System.out.println("?");
            return;
        }
        Map<String, Integer> countMap = new HashMap<>();

        String [] inputArr = input.toLowerCase().split("");

        for(String element : inputArr) {
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);
        }

        int max = 0;
        for(int value : countMap.values()) {
            if(max < value) max = value;
        }

        int duplicateChecker = 0;
        String answer = "";

        for(String key : countMap.keySet()) {
            if(countMap.get(key) == max) {
                answer = key.toUpperCase();
                duplicateChecker++;
            }
        }

        if (duplicateChecker > 1) {
            System.out.println("?");
        } else {
            System.out.println(answer);
        }

    }

}
