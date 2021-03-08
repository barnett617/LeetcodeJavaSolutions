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

var ans = replaceSpaces("Mr John Smith    ", 13);
console.log(ans)