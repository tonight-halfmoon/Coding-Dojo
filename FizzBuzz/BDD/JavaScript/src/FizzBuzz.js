const fizzFilter = require('./fizzFilter').fizzFilter
const buzzFilter = require('./buzzFilter').buzzFilter

class FizzBuzz {
    stringFor(input) {
	const result = this.filter(input)
	if (result === '')
	{
	    return input.toString()
	}
	return result
    }

    filter(input) {
	const filters = [fizzFilter, buzzFilter]
	return this.applyFilters(filters, input)
    }

    applyFilters(filters, input) {
	return filters.map(filter => filter(input)).join('')
    }
}

module.exports = { fizzBuzz: new FizzBuzz() }
