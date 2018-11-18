final class FizzBuzz {

    static String fb(int n) throws Exception
    {
	final Matcher [] matchers = new Matcher[] { new FizzBuzzMatcher(), new Fizz(), new Buzz()};

	if(1 > n)
	{
	    throw new Exception ("Expected 0 < n");
	}

	for(final Matcher matcher : matchers) {
	    if (matcher.isMultipleOf(n))
		{
		    return matcher.answer();
		}
	}
	return String.valueOf(n);
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
