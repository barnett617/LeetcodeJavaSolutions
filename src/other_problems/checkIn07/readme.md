# 打卡Week7

## 题目

- [寻找峰值](https://leetcode-cn.com/problems/find-peak-element/)
- [寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)

## 解答

```js
var findPeekElement = function(nums) {
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
```

```js
var findMin = function(nums) {
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
```

## 总结

- 二分查找