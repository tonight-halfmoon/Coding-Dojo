'use strict';

class FizzBuzz {

    stringFor(input) {
	this.throwIntegerLessThanOneException(input);
	const result = fizz(input);
	return print(input, result);
    }

    addFilter(filter) {
	addFilter(filter);
	return filters.size;
    }

     removeAllFilters() {
	 filters.clear();
	 return filters.size;
    }

    throwIntegerLessThanOneException(input) {
	if (1 > input) {
	    throw new IntegerLessThanOneException(input);
	}
    }
};

const print = (input, result) => {
    if('' === result)
    {
	return input.toString();
    }
    return result;
};

const fizz = (input) => {
    return 0 === input % 3 ? "Fizz": "";
};

const filters = new Set();

const addFilter = (filter) => {
    filters.add(filter);
};

module.exports = FizzBuzz;
