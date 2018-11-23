final class Fizz implements Matcher {   
    public String match(final int integer)
    {
	return 0 == integer % 3? "Fizz": "";
    }
}
