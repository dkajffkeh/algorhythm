package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GreatestCommonDivisor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputChunk = br.readLine().split(" ");
        int n = Integer.parseInt(inputChunk[0]);
        int m = Integer.parseInt(inputChunk[1]);

        int max = Math.max(n, m);
        int min = Math.min(n, m);

        int tempResult = min;
        while (tempResult != 0) {
            tempResult = max % min;
            max = min;
            min = tempResult;
        }
        System.out.println(max);
    }
}
