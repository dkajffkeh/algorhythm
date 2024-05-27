package backjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrinterQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int questions = Integer.parseInt(br.readLine());

        for(int i = 0; i < questions; i++) {

            Queue<Integer> priorities = new LinkedList<>();
            StringTokenizer searchMeta = new StringTokenizer(br.readLine(), " ");

            int printerNumber = Integer.parseInt(searchMeta.nextToken());
            int index = Integer.parseInt(searchMeta.nextToken());

            int max = 0;
            int originNum = 0;


        }
    }

}
