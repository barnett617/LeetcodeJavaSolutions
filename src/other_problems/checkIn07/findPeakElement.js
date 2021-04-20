var findPeekElement = function(nums) {
    if (nums.length === 1) return 0;
    let prev, peek = -1;
    for (let i = 0; (i < nums.length) && (peek < 0); i++) {
        const firstMax = (i === 0) && nums[i + 1] && nums[0] > nums[i + 1];
        const lastMax = (i === nums.length - 1) && nums[i - 1] && (nums[i] > nums[i - 1]);
        const midMax = prev && (nums[i] > prev) && nums[i + 1] && (nums[i] > nums[i + 1]);
        if (firstMax || lastMax || midMax) {
            peek = i;
        } else {
            prev = nums[i];
        }
    }
    return peek;
}

// 一次遍历
var findPeekElement1 = function(nums) {
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] > nums[i + 1]) {
            return i;
        }
    }
    return nums.length - 1;
}

// 迭代二分法
var findPeekElement2 = function(nums) {
    let l = 0, r = nums.length - 1;
    while (l < r) {
        let mid = l + ((r - l) >> 2);
        if (nums[mid] > nums[mid + 1]) {
            r = mid;
        } else {
            l = mid + 1;
        }
    }
    return l;
}

// 递归二分法
var findPeekElement3 = function(nums) {
    var helper = function(nums, l, r) {
        if (l === r) return l;
        let mid = l + ((r - l) >> 1);
        if (nums[mid] > nums[mid + 1]) {
            return helper(nums, l, mid);
        }
        return helper(nums, mid + 1, r);
    }
    return helper(nums, 0, nums.length - 1);
}

function main() {
    var arr = [1, 2, 3, 1];
    console.log(findPeekElement(arr));
}
main();