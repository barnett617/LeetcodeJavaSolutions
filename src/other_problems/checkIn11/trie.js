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