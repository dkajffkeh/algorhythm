package codetree.sample;

import java.util.Scanner;

public class ScannerMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] boundary = new int[n];
        int max = 0;
        for(int i = 0; i < n; i ++) {
            boundary[i] = sc.nextInt();
            if(boundary[i] > max) {
                max = boundary[i];
            }
        }

        System.out.println(recursive(boundary, max, max));
    }

    public static int recursive(int [] boundary, int max, int originalMax) {
        boolean dividable = true;
        for(int i = 0; i < boundary.length; i++) {
            if(max % boundary[i] != 0) {
                dividable = false;
                break;
            }
        }
        if(dividable) return max;

        return recursive(boundary, max + originalMax, originalMax);
    }
}
