/**
 * https://leetcode.com/problems/shuffle-string/
 * @param {string} s
 * @param {number[]} indices
 * @return {string}
 */
 var restoreString2 = function(s, indices) {
    var arr = s.split('');
    for (var i = 0; i < arr.length; i++) {
        if (indices[i] !== i && arr[i] !== arr[indices[i]]) {
            var temp = arr[indices[i]];
            arr[indices[i]] = arr[i];
            arr[i] = temp;
        }
    }
    return arr.join('');
};

// 第一版自己写的，卡在了如果两个对应恰好对应的位置交换后，到下一次交换，又会将位置换回去

// var ans = restoreString("codeleet", [4,5,6,7,0,2,1,3])
// var ans = restoreString("aiohn", [3,1,4,2,0])
// console.log(ans)

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
// 第二版，参考most vote answer 
// https://leetcode.com/problems/shuffle-string/discuss/755923/Used-Cyclic-Sort-with-O(1)-SPACE-and-O(N)-Time-complexity
// 在交换元素位置后，将索引数组对应的位置也进行交换，并直至当前索引变为正确的位置

var ans = restoreString("aiohn", [3,1,4,2,0])
console.log(ans)