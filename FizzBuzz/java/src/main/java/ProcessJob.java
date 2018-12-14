import java.util.List;

enum ProcessJob {
  $;

  static String process(final int input) throws Exception {
    throwInputLessThanOneException(input);
    final List<Filter> filters = FiltersProvider.all();
    final String result = applyFilters(input, filters, "");
    if (result.isEmpty()) {
      return String.valueOf(input);
    }
    return result;
  }

  private static String applyFilters(final int input,
				     final List<Filter> filterers,
				     String result) {
    if (filterers.size() == 0) {
      return result;
    }
    final Filter nextFilter = filterers.remove(0);
    return applyFilters(input, filterers,
			result.concat(nextFilter.filter(input)));
  }

  private static void throwInputLessThanOneException(final int input)
      throws Exception {
    if (1 > input) {
      throw new Exception(
	  "Expected input to be greater than 0, but found ".concat(
	      String.valueOf(input)));
    }
  }
}
