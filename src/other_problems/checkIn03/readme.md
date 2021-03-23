# 打卡Week3

## 题目

- [Calculator LCCI](https://leetcode-cn.com/problems/calculator-lcci/)
- [Daily Temperatures](https://leetcode-cn.com/problems/daily-temperatures/)

## 解答

```js
function isDigit(s) {
    return Number.isInteger(+s) && s !== ' '
}
function calculate(s) {
    const stack = [];
    let num = 0;
    let opt = '+';
    let index = 0;
    while (index < s.length) {
        const ch = s[index];
        if (isDigit(ch)) {
            num = num * 10 + (ch - 0);
        }
        if ((!isDigit(ch) && ch !== ' ') || index === s.length - 1) {
            if (opt === '+') {
                stack.push(num);
            } else if (opt === '-') {
                stack.push(-num);
            } else if (opt === '*') {
                stack.push(stack.pop() * num);
            } else if (opt === '/') {
                let last = stack.pop();
                let temp;
                if (last > 0) {
                    temp = Math.floor(last / num);
                } else {
                    temp = -Math.floor(Math.abs(last) / num);
                }
                stack.push(temp);
            }
            num = 0;
            opt = ch;
        }
        index++;
    }
    let res = 0;
    while (stack && stack.length > 0) {
        res += stack.pop();
    }
    return res;
}
```

```js
function dailyTemperatures(T) {
    const ans = new Array(T.length).fill(0);
    const stack = [];
    for (let i = T.length - 1; i >= 0; i--) {
        while (stack.length && T[stack[stack.length - 1]] <= T[i]) {
            stack.pop();
        }
        ans[i] = stack.length ? stack[stack.length - 1] - i : 0;
        stack.push(i);
    }
    return ans;
}
```

## 总结

- 栈