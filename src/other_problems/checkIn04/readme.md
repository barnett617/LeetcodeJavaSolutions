# 打卡Week4

## 题目

- [队列的最大值](https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/submissions/)
- [滑动窗口的最大值](https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)

## 解答

```js
var MaxQueue = function() {
    this.value = [];
    this.helper = [];
}
MaxQueue.prototype.max_value = function() {
    if (this.helper.length === 0) {
        return -1;
    }
    return this.helper[0];
}
MaxQueue.prototype.push_back = function(value) {
    while (this.helper.length > 0 && this.helper[this.helper.length - 1] < value) {
        this.helper.pop();
    }
    this.value.push(value);
    this.helper.push(value);
}
MaxQueue.prototype.pop_front = function() {
    if (this.value.length === 0) {
        return -1;
    }
    if (this.value[0] === this.helper[0]) {
        this.helper.shift();
        return this.value.shift();
    }
    return this.value.shift();
}
```

```js
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
```

## 总结

- 单调队列