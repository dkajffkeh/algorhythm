package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AratosTenes {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputChunk = br.readLine().split(" ");

        int start = Integer.parseInt(inputChunk[0]);
        int end = Integer.parseInt(inputChunk[1]);

        int [] primes = new int[end + 1];
        primes[0] = primes[1] = 0;

        for(int i = 2; i <= end; i++) {
            primes[i] = i;
        }

        for(int i = 2; i <= end; i++) {
            if(primes[i] == 0) continue;
            for(int j = i + i; j <= end; j += i) {
                primes[j] = 0;
            }
        }

        for(int i = 2; i <= end; i ++) {
            if(primes[i] >= start && primes[i] <= end) {
                System.out.println(primes[i]);
            }
        }
    }
}
