package programmers.level1.neighborblock;

import common.trigger.TestCaseInjectionTrigger;

public class NeighborBlock implements TestCaseInjectionTrigger {

    @Override
    public void trigger() {

    }

    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String centerColor = board[h][w];

        if(h != 0 && centerColor.equals(board[h-1][w])) {
            answer++;
        }

        if(h + 1 != board.length && centerColor.equals(board[h+1][w])) {
            answer++;
        }

        if(w != 0 && centerColor.equals(board[h][w-1])) {
            answer++;
        }

        if(w + 1 != board[h].length && centerColor.equals(board[h][w+1])) {
            answer++;
        }

        return answer;
    }

}
