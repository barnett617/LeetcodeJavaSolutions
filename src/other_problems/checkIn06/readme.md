# 打卡Week6

## 题目

- [动物收容所](https://leetcode-cn.com/problems/animal-shelter-lcci/)
- [接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

## 解答

```js
var AnimalShelf = function() {
    this.dogs = [];
    this.cats = [];
}
AnimalShelf.prototype.enqueue = function(animal) {
    animal[1] ? this.dogs.push(animal) : this.cats.push(animal);
}
AnimalShelf.prototype.dequeueAny = function() {
    const firstDog = this.dogs[0];
    const firstCat = this.cats[0];
    if (firstDog && firstCat) {
        return firstDog[0] < firstCat[0] ? this.dogs.shift() : this.cats.shift();
    }
    if (firstDog && !firstCat) return this.dogs.shift();
    if (firstCat && !firstDog) return this.cats.shift();
    return [-1, -1];
}
AnimalShelf.prototype.dequeueDog = function() {
    if (this.dogs.length > 0) return this.dogs.shift();
    return [-1, -1];
}
AnimalShelf.prototype.dequeueCat = function() {
    if (this.cats.length > 0) return this.cats.shift();
    return [-1, -1];
}
```

```js
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
```

## 总结

- 栈
- 动规/单调栈/双指针(待反刍)