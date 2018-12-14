final class Buzz implements Filter {
  public String match(final int integer) {
    return 0 == integer % 5 ? "Buzz" : "";
  }
}
