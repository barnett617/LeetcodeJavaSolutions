class Trie:
    def __init__(self, words):
        self.d = {}
        for word in words:
            t = self.d
            for w in word:
                if w not in t:
                    t[w] = {}
                t = t[w]
            t['end'] = word
    
    def search(self, s):
        t = self.d
        res = []
        for w in s:
            if w not in t:
                break
            t = t[w]
            if 'end' in t:
                res.append(t['end'])
        return res

class Solution:
    def multiSearch(self, big: str, smalls: List[str]) -> List[List[int]]:
        trie = Trie(smalls)
        hit = collections.defaultdict(list)

        for i in range(len(big)):
            matchs = trie.search(big[i:])
            for word in matchs:
                hit[word].append(i)
        
        res = []
        for word in smalls:
            res.append(hit[word])
        return res
