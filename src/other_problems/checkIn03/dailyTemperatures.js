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