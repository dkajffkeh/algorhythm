package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccessWhenMissingKorea {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int questions = Integer.parseInt(br.readLine());
        String [] patternArr = br.readLine().split("\\*");

        for (int i = 0; i < questions; i++) {
            String fileName = br.readLine();

            if(fileName == null || fileName.equals("")) {
                System.out.println("NE");
                continue;
            }

            String first = patternArr[0];
            String last = patternArr[1];

            if(first == null || first.equals("")) {
                System.out.println("NE");
                continue;
            }

            if(last == null || last.equals("")) {
                System.out.println("NE");
                continue;
            }

            if(fileName.length() < (first.length() + last.length())) {
                System.out.println("NE");
                continue;
            }

            if(!fileName.startsWith(first)) {
                System.out.println("NE");
                continue;
            }

            fileName = fileName.substring(first.length());

            if(fileName.length() < last.length()) {
                System.out.println("NE");
            }

            fileName = fileName.substring(fileName.length() - last.length());

            if(fileName.equals(last)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }

}
