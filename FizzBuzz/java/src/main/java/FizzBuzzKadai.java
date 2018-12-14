import java.util.List;
import java.util.ArrayList;

final class FizzBuzz {

  private static FizzBuzz fizzBuzz = new FizzBuzz();

  private FizzBuzz() {}

  static FizzBuzz getInstance() { return fizzBuzz; }

  String stringFor(final int integer) throws Exception {
    throwIntegerLessThanOneException(integer);
    return process(integer);
  }

  private void throwIntegerLessThanOneException(final int integer)
      throws Exception {
    if (1 > integer) {
      throw new Exception(
	  "Expected integer to be greater than 0, but found ".concat(
	      String.valueOf(integer)));
    }
  }

  private String process(final int integer) {
    List<Filter> filters = FiltersProvider.all();
    final String stringForInteger = applyFilters(integer, filters, "");
    if (stringForInteger.isEmpty()) {
      return String.valueOf(integer);
    }
    return stringForInteger;
  }

  private String applyFilters(final int integer, final List<Filter> filterers,
			      String stringForInteger) {
    if (filterers.size() == 0) {
      return stringForInteger;
    }
    final Filter nextFilter = filterers.remove(0);
    return applyFilters(integer, filterers,
			stringForInteger.concat(nextFilter.filter(integer)));
  }
}
