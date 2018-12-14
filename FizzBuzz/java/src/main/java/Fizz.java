final class Fizz implements Filter {
  public String filter(final int integer) {
    return 0 == integer % 3 ? "Fizz" : "";
  }
}
