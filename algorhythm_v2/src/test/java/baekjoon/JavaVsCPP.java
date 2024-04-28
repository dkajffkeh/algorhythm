package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class JavaVsCPP {

    public static void main(String[] args) throws IOException {
        final String errorMsg = "Error!";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if(input == null || input.equals("")) {
            System.out.println(errorMsg);
            return;
        }
        boolean isJavaCase = false;
        boolean isCPPCase = input.contains("_");
        if(input.split(" ").length > 1) {
            System.out.println(errorMsg);
            return;
        }
        char firstCase = input.toCharArray()[0];
        if(Character.isUpperCase(firstCase)) {
            System.out.println(errorMsg);
            return;
        }
        if(firstCase == '_') {
            System.out.println(errorMsg);
            return;
        }
        if(input.contains("__")) {
            System.out.println(errorMsg);
            return;
        }
        char last = input.toCharArray()[input.length() - 1];
        if(last == '_') {
            System.out.println(errorMsg);
            return;
        }
        for(char element : input.toCharArray()) {
            if(Character.isUpperCase(element)) {
                isJavaCase = true;
                break;
            }
        }
        if(isCPPCase && isJavaCase) {
            System.out.println(errorMsg);
            return;
        }
        if(isJavaCase) {
            javaToCPP(input);
            return;
        }
        cppToJava(input);
    }

    public static void javaToCPP(String str) {
        StringBuilder answer = new StringBuilder();
        for (Character element : str.toCharArray()) {
            if(Character.isUpperCase(element)) {
                answer.append("_").append(element.toString().toLowerCase(Locale.ROOT));
                continue;
            }
            answer.append(element);
        }
        System.out.println(answer);
    }

    public static void cppToJava(String str) {
        StringBuilder answer = new StringBuilder();
        boolean isPreviousUnderScore = false;
        for (String element : str.split("")) {
            if(element.equals("_")) {
                isPreviousUnderScore = true;
                continue;
            }
            if(isPreviousUnderScore) {
                answer.append(element.toUpperCase(Locale.ROOT));
                isPreviousUnderScore = false;
                continue;
            }
            answer.append(element);
        }
        System.out.println(answer);
    }


}
