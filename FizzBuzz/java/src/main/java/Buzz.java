final class Buzz implements Filter {
  public String filter(final int integer) {
      return Divisible.isMultipleOf(integer, 5) ? "Buzz" : "";
  }
}
