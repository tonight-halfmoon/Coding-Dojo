final class Foo implements Filter {

    @Override
    public String filter(final int input){
	return Divisible.isMultipleOf(input, 2) ? "Foo" : "";
    }
    private Foo() {}
    private static final Foo instance = new Foo();
    public static Foo getInstance() { return instance; }
}
