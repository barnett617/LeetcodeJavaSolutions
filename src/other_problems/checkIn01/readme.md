# 打卡Week1

## 题目

- [String to URL LCCI](https://leetcode-cn.com/problems/string-to-url-lcci/)
- [重新排列字符串](https://leetcode-cn.com/problems/shuffle-string/)

## 解答

```javascript
/**
 * https://leetcode-cn.com/problems/string-to-url-lcci/
 * @param {string} S
 * @param {number} length
 * @return {string}
 */
 var replaceSpaces = function(S, length) {
    var arr = S.split('');
    var slow = 0;
    var fast = 0;
    while (fast < arr.length && slow < length) {
        if (arr[slow] === ' ') {
            arr[slow] = '%20';
            fast += 2;
        }
        fast++;
        slow++;
    }
    return arr.join('').substring(0, fast)
};

/**
 * https://leetcode.com/problems/shuffle-string/
 * @param {string} s
 * @param {number[]} indices
 * @return {string}
 */
var restoreString = function(s, indices) {
    var arr = s.split('');
    for (var i = 0; i < arr.length; i++) {
        while (indices[i] !== i) {
            var temp = arr[indices[i]];
            arr[indices[i]] = arr[i];
            arr[i] = temp;

            var tempIndex = indices[indices[i]];
            indices[indices[i]] = indices[i];
            indices[i] = tempIndex;
        }
    }
    return arr.join('');
};
```

## 总结

- 双指针遍历
- 循环交换