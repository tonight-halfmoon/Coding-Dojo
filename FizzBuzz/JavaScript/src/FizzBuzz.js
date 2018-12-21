'use strict';

class FizzBuzz {

    stringFor(input) {
	this.throwIntegerLessThanOneException(input);
	const result = fizz(input);
	return print(input, result);
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


module.exports = FizzBuzz;
