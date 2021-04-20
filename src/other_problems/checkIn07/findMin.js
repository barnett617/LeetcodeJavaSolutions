// 一次遍历
var findMin = function(nums) {
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] > nums[i + 1]) {
            return nums[i + 1];
        }
    }
    return nums[0];
}

// 迭代二分法
var findMin1 = function(nums) {
    let l = 0, r = nums.length - 1;
    while (l < r) {
        let mid = l + ((r - l) >> 1);
        if (nums[mid] > nums[r]) {
            l = mid + 1;
        } else {
            r = mid;
        }
    }
    return nums[l];
}

// 递归二分法
var findMin2 = function(nums) {
    var helper = function(nums, l, r) {
        if (l === r) return nums[l];
        let mid = l + ((r - l) >> 1);
        if (nums[mid] > nums[r]) {
            return helper(nums, mid + 1, r);
        }
        return helper(nums, l, mid);
    }
    return helper(nums, 0, nums.length - 1);
}

function main() {
    var arr = [1, 2, 3, 4, 5];
    var arr1 = [5, 1, 2, 3, 4];
    var arr2 = [4, 5, 1, 2, 3];
    console.log(findMin(arr2));
}
main();