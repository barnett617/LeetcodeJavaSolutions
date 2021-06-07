/**
 * @param {string} big
 * @param {string[]} smalls
 * @return {number[][]}
 */
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

// multiSearch("mississippi", ["is","ppi","hi","sis","i","ssippi"])
multiSearch("", ["a","b","c"])