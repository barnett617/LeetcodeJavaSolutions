function TreeNode(val, left, right) {
    this.val = (val === undefined) ? 0 : val;
    this.left = (left === undefined) ? null : left;
    this.right = (right === undefined) ? null : right;
}

var pathSum = function(root, targetSum) {
    let helper = function(root, target, map, curSum) {
        if (!root) return 0;
        curSum += root.val;
        
        let ans = 0;
        ans += map.get(curSum - target) || 0;
        const curSumVal = map.get(curSum);
        const newVal = curSumVal ? curSumVal + 1 : 1;
        map.set(curSum, newVal);

        ans += helper(root.left, target, map, curSum);
        ans += helper(root.right, target, map, curSum);

        const oldVal = map.get(curSum) - 1;
        map.set(curSum, oldVal);

        return ans;
    }

    const map = new Map();
    map.set(0, 1);
    return helper(root, targetSum, map, 0);
}

pathSum([10,5,-3,3,2,null,11,3,-2,null,1], 8)