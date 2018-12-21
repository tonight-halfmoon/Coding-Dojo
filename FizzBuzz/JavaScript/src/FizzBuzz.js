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
	if('' === result)
	{
	    return input.toString()
	}
	return result
    }
}

module.exports = { fizzBuzz: new FizzBuzz() }

