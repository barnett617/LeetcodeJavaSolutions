package array.problem977;

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }
}

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = s.sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }
}
