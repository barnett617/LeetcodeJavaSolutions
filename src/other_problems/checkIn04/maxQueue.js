var MaxQueue = function() {
    this.value = [];
    this.helper = [];
}
MaxQueue.prototype.max_value = function() {
    if (this.helper.length === 0) return -1;
    return this.helper[0];
}
MaxQueue.prototype.push_back = function(value) {
    while (this.helper.length > 0 && this.helper[this.helper.length - 1] < value) {
        this.helper.pop();
    }
    this.helper.push(value);
    this.value.push(value);
}
MaxQueue.prototype.pop_front = function() {
    if (this.value.length === 0) return -1;
    if (this.value[0] === this.helper[0]) {
        this.helper.shift();
        return this.value.shift();
    }
    return this.value.shift();
}