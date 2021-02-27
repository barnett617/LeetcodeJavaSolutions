package array.problem487;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int left = 0;
        int right = 0;
        int zeros = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros == 2) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    } 
}

public class MaxConsecutiveOnes2 {
    public static void main(String[] args) {
        System.out.println(1);
        Solution s = new Solution();
        int[] nums = {1, 0, 1, 1, 0};
        int count = s.findMaxConsecutiveOnes(nums);
        System.out.println(count);
    }
}
