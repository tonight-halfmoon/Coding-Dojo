let filterJob = require('./FilterJob').filterJob

class FizzBuzz {

    stringFor(input) {
	const result = this.process(input)
	return this.print(input, result)
    }

    process(input) {
	return filterJob.process(input)
    }

    print(input, result) {
	const resultAsString = Array.from(result).join(' ').trim(' ')
	if('' === resultAsString)
	{
	    return input.toString()
	}
	return resultAsString
    }
}

module.exports = { fizzBuzz: new FizzBuzz() }

