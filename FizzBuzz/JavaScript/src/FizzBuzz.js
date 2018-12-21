const fizz = require('./Fizz').FizzFilter

class FizzBuzz {

    stringFor(input) {
	this.throwIntegerLessThanOneException(input)
	const result = fizz(input)
	return print(input, result)
    }

    throwIntegerLessThanOneException(input) {
	if (1 > input) {
	    throw new IntegerLessThanOneException(input)
	}
    }
}

const print = (input, result) => {
    if('' === result)
    {
	return input.toString()
    }
    return result
}

module.exports = { fizzBuzz: new FizzBuzz() }

