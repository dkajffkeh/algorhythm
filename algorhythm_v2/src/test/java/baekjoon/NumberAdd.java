package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberAdd {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String numberChunk = br.readLine();

        int answer = 0;

        for(String numberStr : numberChunk.split("")) {
            answer += Integer.parseInt(numberStr);
        }

        System.out.println(answer);
    }

}
