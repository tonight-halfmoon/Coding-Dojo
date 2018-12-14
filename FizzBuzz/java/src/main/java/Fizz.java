final class Fizz implements Filter {
  public String match(final int integer) {
    return 0 == integer % 3 ? "Fizz" : "";
  }
}
