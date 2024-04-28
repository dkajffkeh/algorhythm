package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    public class OcalString {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String octal = convertBinaryToOctal(br.readLine());
            System.out.println(octal);
        }

        public static String convertBinaryToOctal(String binary) {
            // 주어진 이진수를 3개씩 묶어서 8진수로 변환
            int length = binary.length();
            // 2진수의 길이를 3의 배수로 맞추기 위해 필요한 0의 개수 계산
            int padding = 3 - (length % 3);
            StringBuilder paddedBinary = new StringBuilder();
            // 필요한 0 추가
            for (int i = 0; i < padding; i++) {
                paddedBinary.append("0");
            }
            paddedBinary.append(binary);

            // 3자리씩 묶어서 8진수로 변환
            StringBuilder octal = new StringBuilder();
            for (int i = 0; i < paddedBinary.length(); i += 3) {
                String group = paddedBinary.substring(i, i + 3);
                int decimal = Integer.parseInt(group, 2); // 2진수를 10진수로 변환
                octal.append(Integer.toOctalString(decimal));
            }
            return octal.toString();
        }
}
