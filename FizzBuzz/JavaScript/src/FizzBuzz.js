const filterJob = require('./FilterJob').filterJob
const printerJob = require('./PrinterJob').printerJob

class FizzBuzz {

    stringFor(input) {
	const result = this.process(input)
	return this.print(input, result)
    }

    process(input) {
	return filterJob.process(input)
    }

    print(input, result) {
	return printerJob.process(input, result)
    }
}

module.exports = { fizzBuzz: new FizzBuzz() }

