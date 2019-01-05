class FizzBuzz {
    stringFor(input) {
	var result = this.fizzFilter(input)
	if (0 === input % 5) {
	    result += "Buzz"
	}
	if (result === '')
	{
	    return input.toString()
	}
	return result
    }

    fizzFilter(input) {
	if (0 === input % 3) {
	    return "Fizz"
	}
	return ''
    }
}

module.exports = { fizzBuzz: new FizzBuzz() }
