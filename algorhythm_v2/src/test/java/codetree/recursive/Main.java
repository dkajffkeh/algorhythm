package codetree.recursive;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
            sum += blocks[i];
        }
        int average = sum / n;

        boolean isAllEven = false;
        int moveCount = 0;

        while (!isAllEven) {

            int maxIndex = 0;
            int minIndex = Integer.MAX_VALUE;
            int max = 0;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {

            }


            boolean isEven = true;
            for(int i = 0; i < n; i++) {
                if (blocks[i] != average) {
                    isEven = false;
                    break;
                }
            }
            isAllEven = isEven;
        }
    }
}
