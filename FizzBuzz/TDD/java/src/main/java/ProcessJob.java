import java.util.List;

enum ProcessJob {
  $;

  static String process(final int input) throws Exception {
    throwIntegerLessThanOneException(input);
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

  private static void throwIntegerLessThanOneException(final int input)
      throws Exception {
    if (1 > input) {
	throw new IntegerLessThanOneException(input);
    }
  }
}
