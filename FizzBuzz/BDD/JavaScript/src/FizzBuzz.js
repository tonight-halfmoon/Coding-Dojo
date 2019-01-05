class FizzBuzz {
    stringFor(input) {
	if (0 === input % 5) {
	    return "Buzz"
	}
	if (0 === input % 3) {
	    return "Fizz"
	}
	return input.toString()
    }
}

module.exports = { fizzBuzz: new FizzBuzz() }
