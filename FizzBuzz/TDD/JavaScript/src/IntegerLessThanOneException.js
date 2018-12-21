class IntegerLessThanOneException extends Error {
    constructor(input) {
	const message = "Expected input to be greater than 0, but found ".concat(input);
	super(message);
    }
}
