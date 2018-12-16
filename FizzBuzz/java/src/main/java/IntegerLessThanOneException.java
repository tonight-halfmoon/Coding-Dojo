final class IntegerLessThanOneException extends RuntimeException {
    public IntegerLessThanOneException(int input) {
	super("Expected input to be greater than 0, but found ".concat(String.valueOf(input)));
    }
}
