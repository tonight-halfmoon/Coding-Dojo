const fizzFilter = require('./fizzFilter').fizzFilter

class FizzBuzz {
    stringFor(input) {
	var result = fizzFilter(input)
	if (0 === input % 5) {
	    result += "Buzz"
	}
	if (result === '')
	{
	    return input.toString()
	}
	return result
    }
}

module.exports = { fizzBuzz: new FizzBuzz() }
