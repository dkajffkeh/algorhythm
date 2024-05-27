package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int questions = Integer.parseInt(br.readLine());
        for(int i = 0; i < questions; i ++) {
            String [] brackets = br.readLine().split("");
            Stack<String> bStack = new Stack<>();

            for(String bracket : brackets) {
                if(bStack.isEmpty()) {
                    bStack.push(bracket);
                    continue;
                }

                if(bStack.peek().equals("(") && bracket.equals(")")) {
                    bStack.pop();
                    continue;
                }

                bStack.push(bracket);
            }

            if (bStack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
