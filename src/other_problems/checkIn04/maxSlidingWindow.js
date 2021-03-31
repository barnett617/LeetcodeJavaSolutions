var maxSlidingWindow = function(nums, k) {
    const ans = [];
    if (nums.length < 1) return ans;
    const helper = [];
    for (let i = 0; i < nums.length - k + 1; i++) {
        for (let j = i; j < i + k; j++) {
            const value = nums[j];
            while (helper.length > 0 && helper[helper.length - 1] < value) {
                helper.pop();
            }
            helper.push(value);
        }
        ans.push(helper[0]);
        helper.length = 0;
    }
    return ans;
}