package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalRead {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Map<Integer, Character>> indexCharMaps = new ArrayList<>();

        int maxLength = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i<5; i++) {
            char [] inputMeta = br.readLine().toCharArray();
            Map<Integer, Character> indexMeta = new HashMap<>();

            // saveMax
            if(inputMeta.length > maxLength) maxLength = inputMeta.length;

            for(int j = 0; j < inputMeta.length; j++) {
                indexMeta.put(j, inputMeta[j]);
            }
            indexCharMaps.add(indexMeta);
        }

        for(int i = 0; i<maxLength; i++) {
            for(int j = 0; j < indexCharMaps.size(); j ++) {
                if(indexCharMaps.get(j).containsKey(i)) {
                    stringBuilder.append(indexCharMaps.get(j).get(i));
                }
            }
        }

        System.out.println(stringBuilder);
     }
}
