package array.problem448;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        List<Integer> ans = new LinkedList<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}

class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        Solution s = new Solution();
        List<Integer> ans = s.findDisappearedNumbers(nums);
        System.out.println(ans.toString());
    }
}

