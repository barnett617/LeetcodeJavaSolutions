var LRUCache = function(capacity) {
    this.list = [];
    this.capacity = capacity;
}

LRUCache.prototype.get = function(key) {
    for (let i = 0; i < this.list.length; i++) {
        const item = this.list[i];
        if (item.key === key) {
            const value = item.value;
            this.list.splice(i, 1);
            this.list.push(item);
            return value;
        }
    }
    return -1;
}

LRUCache.prototype.put = function(key, value) {
    for (let i = 0; i < this.list.length; i++) {
        const item = this.list[i];
        if (item.key === key) {
            item.value = value;
            this.list.splice(i, 1);
            this.list.push(item);
            return;
        }
    }
    this.list.push({ key, value });
    if (this.list.length > this.capacity) {
        this.list.shift();
    }
}