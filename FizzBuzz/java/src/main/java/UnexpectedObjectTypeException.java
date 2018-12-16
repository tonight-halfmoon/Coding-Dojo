final class UnexpectedObjectTypeException extends RuntimeException {
    public UnexpectedObjectTypeException(final Object object) {
	super("Unexpected object type: ".concat(object.getClass().toString()));
    }
}
