class FizzBuzz {

    stringFor(input) {
	this.throwIntegerLessThanOneException(input);
	return input.toString();
    }

    throwIntegerLessThanOneException(input) {
	if (1 > input) {
	    throw new IntegerLessThanOneException(input);
	}
    }
};

module.exports = FizzBuzz;
