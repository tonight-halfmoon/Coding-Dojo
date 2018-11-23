final class Buzz implements Matcher {	
    public String match(final int integer)
    {
	return 0 == integer % 5? "Buzz": "";
    }
}
