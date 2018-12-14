import java.util.List;
import java.util.ArrayList;

final class FizzBuzz {

  private final List<Filter> filtererList = new ArrayList<Filter>();

  private static FizzBuzz fizzBuzz = new FizzBuzz();

  private FizzBuzz() {}

  static FizzBuzz getInstance() { return fizzBuzz; }

  String stringFor(final int integer) throws Exception {
    throwIntegerLessThanOneException(integer);
    return process(integer);
  }

  void addFilter(final Filter filterer) { filtererList.add(filterer); }

  void removeAllFilters() { filtererList.clear(); }

  private void throwIntegerLessThanOneException(final int integer)
      throws Exception {
    if (1 > integer) {
      throw new Exception(
          "Expected integer to be greater than 0, but found ".concat(
              String.valueOf(integer)));
    }
  }

  private String process(final int integer) {
    final String stringForInteger = applyFilters(integer, filtererList, "");
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
