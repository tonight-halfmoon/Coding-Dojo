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

    throwIntegerLessThanOneException(input) {
	if (1 > input) {
	    throw new IntegerLessThanOneException(input);
	}
    }
};

const fizz = (input) => {
    return 0 === input % 3 ? "Fizz": "";
};

module.exports = FizzBuzz;
