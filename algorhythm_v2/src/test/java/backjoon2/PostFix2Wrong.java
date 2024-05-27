package backjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFix2Wrong {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder answer = new StringBuilder();
        Stack<Character> operators = new Stack<>();

        for(char element : input.toCharArray()) {
            switch (element) {
                case '+':
                case '-':
                case '/':
                case '*':
                    while(!operators.isEmpty() && priority(operators.peek()) >= priority(element)) {
                        answer.append(operators.pop());
                    }
                    operators.add(element);
                break;
                case '(':
                    operators.add(element);
                break;
                case ')':
                    while(!operators.isEmpty() && operators.peek() != '(') {
                        answer.append(operators.pop());
                    }
                    // '(' 제거
                    operators.pop();
                break;
                default:
                    answer.append(element);
            }
        }
        while(!operators.isEmpty()) {
            answer.append(operators.pop());
        }
        System.out.println(answer);
    }

    private static int priority(char operator) {
        if(operator == '+' || operator == '-') {
            return 1;
        }
        if(operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

}
