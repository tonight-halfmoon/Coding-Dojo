class FizzBuzz {

    stringFor(input) {
	this.throwIntegerLessThanOneException(input);
	const result = this.fizz(input);
	if(result)
	{
	    return result;
	}
	return input.toString();
    }

    fizz(input) {
	return 0 === input % 3 ? "Fizz": "";
    }

    throwIntegerLessThanOneException(input) {
	if (1 > input) {
	    throw new IntegerLessThanOneException(input);
	}
    }
};

module.exports = FizzBuzz;
