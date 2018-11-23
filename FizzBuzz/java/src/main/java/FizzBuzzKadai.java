import java.util.List;
import java.util.ArrayList;

final class FizzBuzz {

    private final List<Matcher> matcherList = new ArrayList<Matcher>();

    private static FizzBuzz fizzBuzz = new FizzBuzz();

    private FizzBuzz() {}

    static FizzBuzz getInstance(){
	return fizzBuzz;
    }

    String stringFor(final int integer) throws Exception
    {
	throwIntegerLessThanOneException(integer);
	return process(integer);
    }

    void addMatcher(final Matcher matcher)
    {
	matcherList.add(matcher);
    }

    void removeAllMatchers()
    {
	matcherList.clear();
    }
    
    private void throwIntegerLessThanOneException(final int integer) throws Exception
    {
	if(1 > integer)
	    {
		throw new Exception ("Expected integer to be greater than 0, but found ".concat(String.valueOf(integer)));
	    }
    }

    private String process(final int integer)
    {
	final String stringForInteger = applyMatchers(integer, matcherList, "");
	if (stringForInteger.isEmpty())
	    {
		return String.valueOf(integer);
	    }
	return stringForInteger;
    }

    private String applyMatchers(final int integer, final List<Matcher> matchers, String stringForInteger)
    {
	if(matchers.size() == 0)
	    {
		return stringForInteger;
	    }
	final Matcher nextMatcher = matchers.remove(0);
	return applyMatchers(integer, matchers, stringForInteger.concat(nextMatcher.match(integer)));
    }
}

interface Matcher {
    String match(final int integer);
}
