package programmers.level1.etc;

import java.util.Arrays;

public class DesktopOrganize {

    public static void main(String[] args) {
        new DesktopOrganize();
    }

    public DesktopOrganize() {
        System.out.println(Arrays.toString(solution(
                new String[]{"..........", ".....#....", "......##..", "...##.....",
                        "....#....."})));
    }

    public int[] solution(String[] wallpaper) {
        int topLine = 0;
        int leftLine = 0;
        int rightLine = 0;
        int bottomLine = 0;

        boolean firstFounded = false;

        for(int i = 0; i<wallpaper.length; i ++) {
            char[] sections = wallpaper[i].toCharArray();

            for(int j = 0; j < sections.length; j++) {

                if(sections[j] == '#') {

                    if(!firstFounded) {
                        topLine = i;
                        leftLine = j;
                        rightLine = j + 1;
                        bottomLine = i + 1;
                        firstFounded = true;
                        continue;
                    }

                    if(leftLine > j) leftLine = j;
                    if(bottomLine < i + 1) bottomLine = i + 1;
                    if(rightLine < j + 1) rightLine = j + 1;

                }
            }
        }


        return new int[]{topLine, leftLine, bottomLine, rightLine};
    }

}
