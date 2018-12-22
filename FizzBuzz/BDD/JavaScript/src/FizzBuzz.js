class FizzBuzz {
    stringFor(input) {
	if (0 === input % 5) {
	    return "Buzz"
	}
	return "Fizz"
    }
}

module.exports = { fizzBuzz: new FizzBuzz() }
