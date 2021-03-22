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

// var s = '3+2*2'
var s = " 3/2 "
// var s = "2+3*2"
var res = calculate(s)
console.log(res);