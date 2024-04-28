package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizeFile {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int files = Integer.parseInt(br.readLine());

        List<String> index = new ArrayList<>();
        Map<String, Integer> fileCount = new HashMap<>();

        for(int i = 0; i < files; i++) {
            String [] fileMeta = br.readLine().split("\\.");
            fileCount.put(fileMeta[1], fileCount.getOrDefault(fileMeta[1], 0) + 1);
        }

        fileCount.forEach((k, v) -> index.add(k));
        Collections.sort(index);

        for (String extension : index) {
            System.out.println(extension + " " + fileCount.get(extension));

        }
    }
}
