package breakcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BreakTest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputChunk = br.readLine().split(" ");
        int n1Length = Integer.parseInt(inputChunk[0]);
        int n2Length = Integer.parseInt(inputChunk[1]);

        if (n2Length > n1Length) {
            System.out.println("No");
            return;
        }

        int[] n1Arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] n2Arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isSame = true;

        for(int i = 0; i < n1Arr.length - n2Arr.length; i ++) {

            isSame = true;

            for(int j = 0; j < n2Arr.length; j++) {
                if(n1Arr[i + j] != n2Arr[j]) {
                    isSame = false;
                    break;
                }
            }

            if(isSame) break;

        }

        if(isSame) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
