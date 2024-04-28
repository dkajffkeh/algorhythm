package baekjoon;

import java.util.Scanner;

public class AddMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] firstArr = new int[n][m];
        int[][] secondArr = new int[n][m];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                firstArr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                secondArr[i][j] = sc.nextInt();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                stringBuilder.append(firstArr[i][j] + secondArr[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

}
