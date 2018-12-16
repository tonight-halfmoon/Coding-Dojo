final class IntegerLessThanOneException extends RuntimeException {
    public IntegerLessThanOneException(final int input) {
	super("Expected input to be greater than 0, but found ".concat(String.valueOf(input)));
    }
}
