function isDigit(s) {
    return Number.isInteger(+s) && s !== ' '
}

function calculate(s) {
    const stack = [];
    let opt = '+';
    let num = 0;
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
                const last = stack.pop();
                let temp;
                if (last < 0) {
                    temp = -Math.floor(Math.abs(last) / num);
                } else {
                    temp = Math.floor(last / num);
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

function main() {
    // const s = "1*2-3/4+5*6-7*8+9/10";
    // const s = '14-3/2';
    // const s = '14/3*2';
    // const s = '42';
    // const s = ' 3/2 ';
    const s = '3+2*2';
    const ans = calculate(s);
    console.log('ans', ans)
}

main()