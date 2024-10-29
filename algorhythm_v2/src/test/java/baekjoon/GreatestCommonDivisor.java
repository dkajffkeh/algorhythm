package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.jupiter.api.Test;

public class GreatestCommonDivisor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] dataChunk = br.readLine().split(" ");

        int first = Integer.parseInt(dataChunk[0]);
        int second = Integer.parseInt(dataChunk[1]);

        int max = Math.max(first, second);
        int min = Math.min(first, second);

        // 최소 공배수
        int divisor = 0;
        for(int i = min; i > 0; i--) {
            if(max%i == 0 && min % i == 0) {
                divisor = i;
                break;
            }
        }
        System.out.println(divisor);
        System.out.println((max/divisor)*(min/divisor)*divisor);
    }

}
