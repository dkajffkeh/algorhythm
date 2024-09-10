package ssocar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SsoCarSolution {

    public void solTest() {
        // expect result : 2
        System.out.println(solution(new String[]{"A 1", "B 2", "C 5", "D 5"}, 10, new String[][]{{"B", "C", "B", "C"}, {"A", "A", "A", "B"}, {"D", "D", "C", "D"}}, 30));
    }

    public int solution(String [] tickets, int roll, String [][] shop, int money) {

        int answer = 0;
        Map<String, Integer> ticketsMeta = new HashMap<>();

        for(String ticket : tickets) {
            String ticketType = ticket.charAt(0) + "";
            int ticketPrice = Integer.parseInt(ticket.substring(2));
            ticketsMeta.put(ticketType, ticketPrice);
        }

        int shopLength = shop.length;

        // 최대 상점 roll 횟수
        int maxRoll = Math.min((money / roll), (shopLength - 1));

        // 2 1 0
        for(int i = maxRoll; i >= 0; i--) {

            StringBuilder ticketChunk = new StringBuilder();
            int leftAmount = money - (i * roll);

            for(int j = 0; j <= i; j ++) {
                ticketChunk.append(String.join("", shop[j]));
            }

            char[] ticketChunkArr = ticketChunk.toString().toCharArray();
            Arrays.sort(ticketChunkArr);

            // 정렬된 티켓
            StringBuilder sortedTicketChunk = new StringBuilder(new String(ticketChunkArr));

            List<Entry<String, Integer>> entryList = new ArrayList<>(ticketsMeta.entrySet());

            // 값(가격)을 기준으로 리스트 정렬
            entryList.sort(Map.Entry.comparingByValue());

            for (Map.Entry<String, Integer> entry : entryList) {
                String goldenTicket = entry.getKey().repeat(3);
                Integer ticketPrice  = entry.getValue() * 3;

                while (sortedTicketChunk.toString().contains(goldenTicket)) {

                }
            }
        }

        return 0;
    }
}
