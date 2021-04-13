var trap = function(height) {
    const n = height.length;
    if (!n) return n;
    const leftmax = new Array(n).fill(0);
    leftmax[0] = height[0];
    for (let i = 1; i < n; i++) {
        leftmax[i] = Math.max(leftmax[i-1], height[i]);
    }
    const rightmax = new Array(n).fill(0);
    rightmax[n-1] = height[n-1];
    for (let i = n - 2; i >= 0; i--) {
        rightmax[i] = Math.max(rightmax[i+1], height[i]);
    }
    let ans = 0;
    for (let i = 0; i < n; i++) {
        ans += Math.min(leftmax[i], rightmax[i]) - height[i];
    }
    return ans;
}

var trap2 = function(height) {
    let ans = 0;
    const stack = [];
    const n = height.length;
    for (let i = 0; i < n; i++) {
        while (stack.length && height[i] > height[stack[stack.length - 1]]) {
            const top = stack.pop();
            if (!stack.length) break;
            const peek = stack[stack.length - 1];
            const left = peek;
            const curWidth = i - left - 1;
            const curHeight = Math.min(height[left], height[i]) - height[top];
            ans += curWidth * curHeight;
        }
        stack.push(i);
    }
    return ans;
}

var trap3 = function(height) {
    let ans = 0;
    let left = 0, right = height.length - 1;
    let leftmax = 0, rightmax = 0;
    while (left < right) {
        leftmax = Math.max(leftmax, height[left]);
        rightmax = Math.max(rightmax, height[right]);
        if (height[left] < height[right]) {
            ans += leftmax - height[left];
            left++;
        } else {
            ans += rightmax - height[right];
            right--;
        }
    }
    return ans;
}

// console.log(trap([0,1,0,2,1,0,1,3,2,1,2,1]));
console.log(trap2([0,1,0,2,1,0,1,3,2,1,2,1]));