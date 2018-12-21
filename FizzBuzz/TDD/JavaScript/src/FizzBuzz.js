const filterJob = require('./FilterJob').filterJob
const printerJob = require('./PrinterJob').printerJob

class FizzBuzz {

    stringFor(input) {
	const result = this.process(input)
	return this.print(result)
    }

    process(input) {
	return filterJob.process(input)
    }

    print(result) {
	return printerJob.process(result)
    }
}

module.exports = { fizzBuzz: new FizzBuzz() }

