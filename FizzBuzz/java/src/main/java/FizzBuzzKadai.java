final class FizzBuzz {

    static String stringFor(final int integer) throws Exception
    {
	throwIntegerLessThanOneException(integer);
	return process(integer);
    }

    private static void throwIntegerLessThanOneException(final int integer) throws Exception
    {
	if(1 > integer)
	    {
		throw new Exception ("Expected integer greater than 0, but found ".concat(String.valueOf(integer)));
	}
    }

    private static String process(final int integer)
    {
	final Matcher [] matchers = new Matcher[] { new FizzBuzzMatcher(), new Fizz(), new Buzz()};
	for(final Matcher matcher : matchers) {
	    if (matcher.isMultipleOf(integer))
		{
		    return matcher.answer();
		}
	}
	return String.valueOf(integer);
    }
}

interface Matcher {

    Boolean isMultipleOf(final int n);
    String answer();
}

final class Fizz implements Matcher {

    public Boolean isMultipleOf(final int n)
    {
	return 0 == n % 3;
    }

    public String answer()
    {
	return "Fizz";
    }
}

final class Buzz implements Matcher {

    public Boolean isMultipleOf(final int n)
    {
	return 0 == n % 5;
    }

    public String answer()
    {
	return "Buzz";
    }
}

final class FizzBuzzMatcher implements Matcher {

    public Boolean isMultipleOf(final int n)
    {
	return 0 == n % 3 && 0 == n % 5;
    }

    public String answer()
    {
	return "FizzBuzz";
    }
}
