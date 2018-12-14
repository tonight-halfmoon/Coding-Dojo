final class Fizz implements Filter {
  public String filter(final int integer) {
      return Divisible.isMultipleOf(integer, 3) ? "Fizz" : "";
  }
}
