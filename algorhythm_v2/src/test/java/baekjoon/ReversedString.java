package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReversedString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String questionInput = br.readLine();

        if(questionInput == null || questionInput.equals("")) {
            System.out.println();
            return;
        }

        String [] splitedQuestion = questionInput.split("");

        boolean tagIdle = false;

        StringBuilder answer = new StringBuilder();

        StringBuilder reversed = new StringBuilder();

        for(String element : splitedQuestion) {

            if(element.equals("<")) {
                tagIdle = true;
                answer.append(reversed.reverse());
                reversed = new StringBuilder();
                answer.append(element);
                continue;
            }

            if(tagIdle && !element.equals(">")) {
                answer.append(element);
                continue;
            }

            if(tagIdle) {
                answer.append(element);
                tagIdle = false;
                continue;
            }

            if(element.equals(" ")) {
                answer.append(reversed.reverse());
                reversed = new StringBuilder();
                answer.append(element);
                continue;
            }

            reversed.append(element);
        }

        answer.append(reversed.reverse());

        System.out.println(answer);
    }

}
