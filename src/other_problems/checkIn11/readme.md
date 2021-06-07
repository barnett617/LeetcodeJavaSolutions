# 打卡Week11

## 题目

- [多次搜索](https://leetcode-cn.com/problems/multi-search-lcci/)
- [实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)

## 解答

```js
var multiSearch = function(big, smalls) {

    function Trie (words) {
        this.dict = {};
        for (const word of words) {
            let t = this.dict;
            for (const w of word) {
                if (!t[w]) {
                    t[w] = {};
                }
                t = t[w];
            }
            t['end'] = word;
        }
    }

    Trie.prototype.search = function(s) {
        let t = this.dict;
        const res = [];
        for (const w of s) {
            if (!t[w]) {
                break;
            }
            t = t[w];
            if (t['end']) {
                res.push(t['end']);
            }
        }
        return res;
    }

    const trie = new Trie(smalls);
    const hit = {};

    for (let i = 0; i < big.length; i++) {
        const matches = trie.search(big.slice(i));
        console.log('matches', matches)
        for (const word of matches) {
            if (hit[word]) {
                hit[word].push(i);
            } else {
                hit[word] = [i];
            }
        }
    }

    const res = [];
    for (const word of smalls) {
        res.push(hit[word] || []);
    }
    return res;
};
```

```js
var Trie = function() {
    this.dict = {};
}

Trie.prototype.insert = function(word) {
    let cur = this.dict;
    for (const char of word) {
        if (!cur[char]) {
            cur[char] = {};
        }
        cur = cur[char];
    }
    cur['end'] = word;
}

Trie.prototype.search = function(word) {
    let cur = this.dict;
    for (const char of word) {
        if (!cur[char]) return false;
        cur = cur[char];
    }
    return Boolean(cur['end']);
}

Trie.prototype.startsWith = function(prefix) {
    let cur = this.dict;
    for (const char of prefix) {
        if (!cur[char]) return false;
        cur = cur[char];
    }
    return true;
}
```

## 总结

- Trie树