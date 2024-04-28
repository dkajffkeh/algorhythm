package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackJack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] firstLine = br.readLine().split(" ");
        String [] secondLine = br.readLine().split(" ");

        int cardNum = Integer.parseInt(firstLine[0]);
        int maxScore = Integer.parseInt(firstLine[1]);
        int [] cards = new int[secondLine.length];

        for (int i = 0 ; i < secondLine.length; i++) {
            cards[i] = Integer.parseInt(secondLine[i]);
        }

        if(cards.length == 3) {
            System.out.println(cards[0] + cards[1] + cards[2]);
            return;
        }

        int selectedMax = 0;

        for(int i = 0; i < cardNum - 2;  i++) {
            int pointer1 = cards[i];

            for(int j = i + 1; j < cardNum - 1; j++) {

                int pointer2 = cards[j];

                for(int k = j + 1; k < cardNum; k++) {

                    int pointer3 = cards[k];

                    int extractedValue = pointer1 + pointer2 + pointer3;

                    if(extractedValue > selectedMax && extractedValue <= maxScore) {
                        selectedMax = extractedValue;
                    }
                }
            }
        }
        System.out.println(selectedMax);
    }
}
