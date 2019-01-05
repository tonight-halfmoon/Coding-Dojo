const fizzFilter = require('./fizzFilter').fizzFilter
const buzzFilter = require('./buzzFilter').buzzFilter

class FizzBuzz {
    stringFor(input) {
	var result = fizzFilter(input)
	result += buzzFilter(input)
	if (result === '')
	{
	    return input.toString()
	}
	return result
    }
}

module.exports = { fizzBuzz: new FizzBuzz() }
