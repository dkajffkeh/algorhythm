package programmers.bigo;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BigOTest {

    @Test
    void binarySearchTest() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31}; // 정렬된 배열

        int target = 31;
        int index = binarySearch(arr, target);

        if (index != -1)
            System.out.println("찾는 값 " + target + "의 인덱스는 " + index + "입니다.");
        else
            System.out.println("찾는 값 " + target + "이 배열에 없습니다.");
    }

    @Test
    void removeFirst() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.remove(0);
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 중간 요소가 찾는 값인지 확인
            if (arr[mid] == target)
                return mid;

            // 중간 요소보다 작은 부분을 탐색
            if (arr[mid] < target)
                left = mid + 1;
                // 중간 요소보다 큰 부분을 탐색
            else
                right = mid - 1;
        }

        // 찾는 값이 없으면 -1 반환
        return -1;
    }
}
