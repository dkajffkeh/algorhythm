package backjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PostFix2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numbers = Integer.parseInt(br.readLine());
        String postFix = br.readLine();

        Map<Character, Double> charMap = new HashMap<>();

        for(int i = 0; i< numbers; i++) {
            charMap.put((char)(65 + i), Double.parseDouble(br.readLine()));
        }

        Stack<Double> numberStack = new Stack<>();

        for(char postFixArr : postFix.toCharArray()) {

            // 알파벳인 경우 Stack 에 쌓음.
            if((double)postFixArr >= 65 && (double)postFixArr <= 90) {
                numberStack.add(charMap.get(postFixArr));
                continue;
            }

            // 연산자일 경우
            double fi = numberStack.pop();
            double li = numberStack.pop();
            double result = 0;
            switch (postFixArr) {
                case '*' : result = li * fi; break;
                case '+' : result = li + fi; break;
                case '/' : result = li / fi; break;
                case '-' : result = li - fi; break;
                default : result = 0;
            };
            numberStack.add(result);
        }

        System.out.printf("%.2f", numberStack.pop());
    }

}
