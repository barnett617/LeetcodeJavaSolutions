package array.problem1089;

import java.util.Arrays;

class Solution {
    public void duplicateZeros(int[] arr) {
        int dup = 0;
        int len = arr.length - 1;
        for (int left = 0; left <= len - dup; left++) {
            if (arr[left] == 0) {
                if (left == len - dup) {
                    arr[len] = 0;
                    len--;
                    break;
                }
                dup++;
            }
        }
        int last = len - dup;
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + dup] = 0;
                dup--;
                arr[i + dup] = 0;
            } else {
                arr[i + dup] = arr[i];
            }
        }
    }
}

public class DuplicateZeros {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        Solution s = new Solution();
        System.out.println(Arrays.toString(arr));
        s.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
