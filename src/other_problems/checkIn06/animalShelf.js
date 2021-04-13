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