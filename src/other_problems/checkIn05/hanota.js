var hanota = function(A, B, C) {
    var helper = function(n, p1, p2, p3) {
        // 递归终止条件：当盘子1只有一个时，可以直接移动到盘子3
        if (n === 1) {
            p3.push(p1.pop());
        }
        if (n > 1) {
            // 把盘子1最底部以上的都先放到盘子2（借助于盘子3）
            helper(n - 1, p1, p3, p2);
            // 当上述完成后，盘子1应该只剩1个，将其放到盘子3
            p3.push(p1.pop());
            // 再将盘子2的放到盘子3（借助于盘子1）
            helper(n - 1, p2, p1, p3);
        }
    }
    helper(A.length, A, B, C);
}

function main() {
    var A = [3, 2, 1, 0];
    // var A = [2, 1, 0];
    var B = [];
    var C = [];
    hanota(A, B, C);
    console.log(A, B, C);
}
main();