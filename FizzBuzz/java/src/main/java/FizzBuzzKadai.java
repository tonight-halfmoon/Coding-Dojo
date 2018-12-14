import java.util.List;
import java.util.ArrayList;

final class FizzBuzz {

    private final List<Filter> matcherList = new ArrayList<Filter>();

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

    void addFilter(final Filter matcher)
    {
	matcherList.add(matcher);
    }

    void removeAllFilters()
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
	final String stringForInteger = applyFilters(integer, matcherList, "");
	if (stringForInteger.isEmpty())
	    {
		return String.valueOf(integer);
	    }
	return stringForInteger;
    }

    private String applyFilters(final int integer, final List<Filter> matchers, String stringForInteger)
    {
	if(matchers.size() == 0)
	    {
		return stringForInteger;
	    }
	final Filter nextFilter = matchers.remove(0);
	return applyFilters(integer, matchers, stringForInteger.concat(nextFilter.match(integer)));
    }
}
