package programmers.bigo;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class MergeSortTest {

    @Test
    void main() {
        int[] arr = {12, 11, 13, 5, 6, 7}; // 정렬할 배열

        System.out.println("정렬 전: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("정렬 후: " + Arrays.toString(arr));
    }

    private void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 배열이 비어있거나 크기가 1 이하인 경우 정렬할 필요가 없음
        }
        mergeSort(arr, 0, arr.length - 1); // 병합 정렬 호출
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; // 중간 지점 계산
            mergeSort(arr, left, mid); // 왼쪽 부분 배열 정렬
            mergeSort(arr, mid + 1, right); // 오른쪽 부분 배열 정렬
            merge(arr, left, mid, right); // 정렬된 부분 배열 병합
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // 왼쪽 부분 배열 크기
        int n2 = right - mid; // 오른쪽 부분 배열 크기

        // 임시 배열 생성
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // 왼쪽과 오른쪽 부분 배열에 값 복사
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // 병합 단계
        int i = 0, j = 0;
        int k = left; // 병합 결과를 저장할 배열의 인덱스
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 남은 요소들 복사
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

}
