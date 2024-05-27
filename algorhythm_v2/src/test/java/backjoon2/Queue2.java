package backjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Queue2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int questions = Integer.parseInt(br.readLine());
        Deque<Integer> integers = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer;


        for (int i = 0; i < questions; i++) {
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            switch (stringTokenizer.nextToken()) {
                case "push":
                    integers.offer(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "pop": {
                    Integer ite = integers.poll();
                    if (ite == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(ite).append("\n");
                    }
                }
                break;
                case "size": {
                    sb.append(integers.size()).append("\n");
                } break;
                case "empty": {
                    if(integers.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                } break;
                case "front": {
                    Integer ite = integers.peek();
                    if (ite == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(ite).append("\n");
                    }
                } break;
                case "back": {
                    Integer ite = integers.peekLast();
                    if (ite == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(ite).append("\n");
                    }
                }
                default:
            }
        }
        System.out.println(sb);
    }
}
