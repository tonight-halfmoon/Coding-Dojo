'use strict';

class FizzBuzz {

    stringFor(input) {
	this.throwIntegerLessThanOneException(input);
	const result = fizz(input);
	if(result)
	{
	    return result;
	}
	return input.toString();
    }

    addFilter(filter) {
	addFilter(filter);
	return filters.size;
    }

    throwIntegerLessThanOneException(input) {
	if (1 > input) {
	    throw new IntegerLessThanOneException(input);
	}
    }
};

const fizz = (input) => {
    return 0 === input % 3 ? "Fizz": "";
};

const filters = new Set();

const addFilter = (filter) => {
    filters.add(filter);
};

module.exports = FizzBuzz;
