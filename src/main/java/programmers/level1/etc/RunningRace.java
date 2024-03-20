package programmers.level1.etc;

import java.util.HashMap;
import java.util.Map;

public class RunningRace {

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playersIndex = new HashMap<>();
        for(int i = 0; i < players.length; i ++) {
            playersIndex.put(players[i], i);
        }
        for(String calling: callings) {
            String switchPlayer = players[playersIndex.get(calling) - 1];
            players[playersIndex.get(calling) - 1] = calling;
            players[playersIndex.get(calling)] = switchPlayer;

            playersIndex.put(calling, playersIndex.get(calling) - 1);
            playersIndex.put(switchPlayer, playersIndex.get(switchPlayer) + 1);
        }
        return players;
    }

}
